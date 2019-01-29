package me.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.dao.impl.DBConnectionImpl;
import me.domain.Course;
import me.domain.ErrorMess;
import me.domain.Student;
import me.service.IFindCourseBySidService;

public class FindCourseBySidServiceImpl implements IFindCourseBySidService{

	public static ArrayList<Course> find(int id) throws ErrorMess{

        ArrayList<Course> coursesArrayList = new ArrayList<Course>();

		try {

			Connection con = DBConnectionImpl.getConnection();
			String sql = "select distinct courseid, coursename from select_course where stu_id = ?";
			PreparedStatement ps = null;
			ResultSet rs = null;

			// 执行查询并返回结果集
            assert con != null;
            ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) { // 通过next来索引：判断是否有下一个记录
				int cid = rs.getInt("courseid");
				String name = rs.getString("coursename");

				Course course = new Course(cid, name);
				coursesArrayList.add(course);
			}
			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return coursesArrayList;
	}
}
