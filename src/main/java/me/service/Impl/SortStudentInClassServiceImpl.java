package me.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.domain.Score;
import me.domain.Student;
import me.service.ISortStudentInClassService;

public class SortStudentInClassServiceImpl implements ISortStudentInClassService{
	public static ArrayList<Score> sort(int sid, int grade) throws ErrorMess {
		ArrayList<Score> scores = new ArrayList<Score>();
		Student student = FindStudentByIdServiceImpl.find(sid);

		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = "select stu_id, sname, cid , cname, sum(score) AS sumScore, grade\n" +
						"from select_course\n" +
						"where (cid = ? AND grade = ? AND score != -1)\n" +
						"group by stu_id";

			PreparedStatement ps = null;
			ResultSet rs = null;

			// 执行查询并返回结果集
			assert con != null;
			ps = con.prepareStatement(sql);
			ps.setInt(1, student.getCid());
			ps.setInt(2, grade);
			rs = ps.executeQuery();

			while (rs.next()) { // 通过next来索引：判断是否有下一个记录

				int stu_id = rs.getInt("stu_id");
				String sname = rs.getString("sname");
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				int sumScore = rs.getInt("sumScore");

				Score score = new Score(stu_id, sname, cid, cname, -1, "", grade, sumScore);
				scores.add(score);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return scores;
	}
}
