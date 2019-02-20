package me.service.Impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.domain.User;
import me.service.IRegisterService;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterServiceImpl implements IRegisterService{
	public static void add(User user) throws ErrorMess {

        try {

            Connection con = DBConnectionImpl.getConnection();
            String sql = "insert into user (account, password, type, ischeck, email)  values (?, ?, ?, ?, ?)";
            PreparedStatement ps = null;

            assert con != null;
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getAccount());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getType());
            ps.setInt(4, 0);
            ps.setString(5, user.getEmail());

            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (MySQLIntegrityConstraintViolationException e) {
            throw new ErrorMess("已存在该用户");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorMess("其他问题,请...");
        }

	}
}
