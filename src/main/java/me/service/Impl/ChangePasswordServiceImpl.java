package me.service.Impl;

import me.dao.impl.DBConnectionImpl;
import me.service.ChangePasswordService;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author: wt
 * @Date: 2019/2/18 17:09
 */
public class ChangePasswordServiceImpl implements ChangePasswordService {

    @Override
    public void change(String account, String password) {
        String sql = "update user set password = ? where account like ?";
        Connection connection = DBConnectionImpl.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
