package me.service.Impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.service.IModifyStudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyStudentServiceImpl implements IModifyStudentService {
	public static void modify(int sid, String name, int cid) throws ErrorMess {
		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			assert con != null;

			//检查是否有该学号的学生
			sql = "select * from student where sid = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();
			if (!rs.next()){
				throw new ErrorMess("没有这个学号!");
			}

			//修改该学生信息
			sql = "update student set sname = ?, cid = ? where sid = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, cid);
			ps.setInt(3, sid);
			ps.executeUpdate();
			ps.close();
			con.close();

		}catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorMess("其他问题,请...");
		}
	}
}
