package me.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.domain.Score;
import me.service.IFindScoreByCourseService;

public class FindScoreByCourseServiceImpl implements IFindScoreByCourseService{
	public static ArrayList<Score> find(int sid, int courseid) throws ErrorMess {
		ArrayList<Score> scores = new ArrayList<Score>();

		try {

			Connection con = DBConnectionImpl.getConnection();
			String sql = "select * from select_course where stu_id = ? AND courseid = ?";
			PreparedStatement ps = null;
			ResultSet rs = null;

			// 执行查询并返回结果集
			assert con != null;
			ps = con.prepareStatement(sql);
			ps.setInt(1, sid);
			ps.setInt(2, courseid);
			rs = ps.executeQuery();

			while (rs.next()) { // 通过next来索引：判断是否有下一个记录

				int stu_id = rs.getInt("stu_id");
				String sname = rs.getString("sname");
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				String coursename = rs.getString("coursename");
				int score1 = rs.getInt("score");
				int grade = rs.getInt("grade");


				Score score = new Score(stu_id, sname, cid, cname, courseid, coursename, grade, score1);
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
