package me.service.Impl;

import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.domain.Student;
import me.service.IDeleteStudentByIdService;
import me.web.controller.FindStudentById;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteStudentByIdServiceImpl implements IDeleteStudentByIdService{

	public static void delete(int id) throws ErrorMess {
		try {
			Connection con = DBConnectionImpl.getConnection();
            String sql = null;
			PreparedStatement ps = null;
            ResultSet rs = null;
            assert con != null;

			//检查是否有该学号的学生
            sql = "select * from student where sid = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                throw new ErrorMess("没有这个学生!");
            }

            //删除该学生
            sql = "delete from student where sid = ?";
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
