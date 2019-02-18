package me.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.service.IFindAllItemsService;

public class FindAllItemServiceImpl implements IFindAllItemsService {
	public static ArrayList<Integer> find(int sid) throws ErrorMess {

		ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

		try {

			Connection con = DBConnectionImpl.getConnection();
			String sql = "select distinct grade from student_course where stu_id = ?";
			PreparedStatement ps = null;
			ResultSet rs = null;

			// 执行查询并返回结果集
			assert con != null;
			ps = con.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();

			while (rs.next()) { // 通过next来索引：判断是否有下一个记录

                Integer integer = rs.getInt("grade");
				integerArrayList.add(integer);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return integerArrayList;
	}
}
