package me.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import me.domain.User;

public class LoginDaoImpl {
	public static void find(User user) {
		Connection con = (Connection) DBConnectionImpl.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where account like ?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, user.getAccount());
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString("ischeck").equals("1") && rs.getString("password").equals(user.getPassword())) {
					// 账号密码均正确,而且账号通过审核,获取用户身份
					user.setType(rs.getInt("type"));
				} else if (rs.getString("ischeck").equals("0")) {
					// 此处账号未通过审核的标志
					user.setType(-1);
				} else {
					// 密码错误
					user.setPassword(null);
				}
			} else {
				// 账号为空
				user.setAccount(null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionImpl.free(con, ps, rs);
		}
	}
}
