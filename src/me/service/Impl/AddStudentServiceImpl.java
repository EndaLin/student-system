package me.service.Impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.domain.Student;
import me.service.IAddStudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddStudentServiceImpl implements IAddStudentService {
    public static void add(Student stu) throws ErrorMess {

        int sid = 0;

        try {
            Connection con = DBConnectionImpl.getConnection();
            String sql = "insert into student (sname, cid)  values (?,?)";
            PreparedStatement ps = null;

            assert con != null;
            ps = con.prepareStatement(sql);
            ps.setString(1, stu.getSname());
            ps.setInt(2, stu.getCid());
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (MySQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            throw new ErrorMess("没有该班级号");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorMess("其他问题,请...");
        }

        try {
            Connection con = DBConnectionImpl.getConnection();
            String sql = "select max(sid) AS maxSid from student";
            ResultSet rs = null;
            PreparedStatement ps = null;

            assert con != null;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                sid = rs.getInt("maxSid");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorMess("其他问题,请...");
        }

        try {
            Connection con = DBConnectionImpl.getConnection();
            String sql = "insert into user (account, password, type, ischeck)  values (?,?,?,?)";
            assert con != null;
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            con.setAutoCommit(false);

            ps.setString(1, String.valueOf(sid));
            ps.setString(2, "123");
            ps.setInt(3, 1);
            ps.setInt(4, 1);
            ps.execute();

            con.commit();
            con.close();

        } catch (MySQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            throw new ErrorMess("没有该班级号");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorMess("其他问题,请...");
        }
    }
}
