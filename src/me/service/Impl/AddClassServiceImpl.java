package me.service.Impl;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.service.IAddClassService;

import java.sql.*;

public class AddClassServiceImpl implements IAddClassService {
    public static void add(String name, int grade) throws ErrorMess {

        try {

            Connection con = DBConnectionImpl.getConnection();
            String sql = "insert into class (cname, cgrade)  values (?,?)";
            PreparedStatement ps = null;

            assert con != null;
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, grade);
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (MySQLIntegrityConstraintViolationException e) {
            throw new ErrorMess("已存在该班级");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorMess("其他问题,请...");
        }
    }
}
