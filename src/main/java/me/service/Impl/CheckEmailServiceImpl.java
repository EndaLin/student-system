package me.service.Impl;

import me.dao.impl.DBConnectionImpl;
import me.service.CheckEmailService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: wt
 * @Date: 2019/2/18 16:19
 */
public class CheckEmailServiceImpl implements CheckEmailService {

    @Override
    public boolean check(String account, String email) {
        String sql = "select * from user where account like ? and email like ?";
        Connection connection = DBConnectionImpl.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
