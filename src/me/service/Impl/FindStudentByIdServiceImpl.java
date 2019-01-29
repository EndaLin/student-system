package me.service.Impl;

import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindStudentByIdServiceImpl {
	public static Student find(int id) throws ErrorMess {

		Student student = null;

		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = "select * from student_class where sid = ?";
			PreparedStatement ps = null;
			ResultSet rs = null;

			//执行查询并返回结果集
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()){  //通过next来索引：判断是否有下一个记录
				int sid = rs.getInt("sid");
				String name = rs.getString("sname");
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				int cgrade = rs.getInt("cgrade");

				student = new Student(sid, name, cid, cname, cgrade);
			}else {
			    throw new ErrorMess("没有这个学生!");
            }

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}
}
