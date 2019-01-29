package me.service.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import me.dao.impl.DBConnectionImpl;
import me.domain.User;
import me.service.IFindAllAccountsWithoutCheckService;

public class FindAllAccountsWithoutCheckServiceImpl implements IFindAllAccountsWithoutCheckService{
	public static ArrayList<User> find() {
		ArrayList<User> userArrayList = new ArrayList<User>();

		try {

			Connection con = DBConnectionImpl.getConnection();
			String sql = "select * from user where ischeck = 0";
			assert con != null;
			Statement state = con.createStatement();

			//执行查询并返回结果集
			ResultSet rs = state.executeQuery(sql);

			while(rs.next()){  //通过next来索引：判断是否有下一个记录
				String account = rs.getString("account");
				String password = rs.getString("password");
				int type = rs.getInt("type");

				User user = new User(account, password, type);
				userArrayList.add(user);
			}
			rs.close();
			state.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userArrayList;
	}
}
