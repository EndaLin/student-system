package me.service.Impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.service.IModifyCourseNameService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyCourseNameServiceImpl implements IModifyCourseNameService {
	public static void modify(int id, String name) throws ErrorMess {
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
                throw new ErrorMess("没有这个课程号!");
            }

            //修改该课程
            sql = "update course set name = ? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			con.close();

		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new ErrorMess("已存在该课程");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorMess("其他问题,请...");
		}
	}
}
