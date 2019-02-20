package me.service.Impl;

import java.sql.*;
import java.util.ArrayList;

import me.dao.impl.DBConnectionImpl;
import me.domain.Student;

public class FindStudentByCidServiceImpl {
	public static ArrayList<Student> find(int id) {
		ArrayList<Student> studentArrayList = new ArrayList<>();

		try {

			Connection con = DBConnectionImpl.getConnection();
			String sql = "select * from student_class where cid = ?";
			PreparedStatement ps = null;
			ResultSet rs = null;

			// 执行查询并返回结果集
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
           // 通过next来索引：判断是否有下一个记录
			while (rs.next()) {
				int sid = rs.getInt("sid");
				String name = rs.getString("sname");
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				int cgrade = rs.getInt("cgrade");

				Student student = new Student(sid, name, cid, cname, cgrade);
				studentArrayList.add(student);
			}
			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return studentArrayList;
	}
}
