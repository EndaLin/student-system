package me.service.Impl;

import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.service.IDeleteCourseByIdService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteCourseByIdServiceImpl implements IDeleteCourseByIdService {
	public static void delete(int id) throws ErrorMess {
		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			assert con != null;

			//检查是否有该课程号的课程
			sql = "select * from course where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()){
				throw new ErrorMess("没有这个课程!");
			}

			//删除该课程
			sql = "delete from course where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorMess("其他问题,请...");
		}
	}
}
