package me.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.service.IAddCourseByExcelService;



public class AddCourseByExcelServiceImpl implements IAddCourseByExcelService {
	public static void add(List<List<String>> list) throws ErrorMess {
		String name; // 课程名称

		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = "insert into course (name) values (?)";
			assert con != null;
			PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			con.setAutoCommit(false);

			// 把list中的数据读出,并封装到stu里面,(list里面存放的是从Excel中读取出来的数据)
			for (List<String> cellList : list) {

				if (cellList.size() != 1) {
					throw new ErrorMess("数据格式错误,请核实检查!");
				}
				// 读取该行每一列的相关信息
				name = cellList.get(0);

				try {
					ps.setString(1, name);
					System.out.println(name);
					ps.execute();
				} catch (Exception e) {
					e.printStackTrace();
					throw new ErrorMess("已有该课程:" + name);
				}
			}

			con.commit();
			con.close();

		} catch (ErrorMess e) {
			throw e;
		} catch (Exception e) {
			throw new ErrorMess("其他问题,请...");
		}
	}
}
