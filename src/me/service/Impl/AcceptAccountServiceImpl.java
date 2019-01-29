package me.service.Impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.service.IAcceptAccountService;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AcceptAccountServiceImpl implements IAcceptAccountService {
	public static void accept(String account) {

        try {

            Connection con = DBConnectionImpl.getConnection();
            String sql = "update user set ischeck = 1 where account = ?";
            PreparedStatement ps = null;

            assert con != null;
            ps = con.prepareStatement(sql);
            ps.setString(1, account);
            ps.executeUpdate();
            ps.close();
            con.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

	}
}
