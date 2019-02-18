package me.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.domain.Student;
import me.service.IAddStudentsByExcelService;

public class AddStudentsByExcelServiceImpl implements IAddStudentsByExcelService {
	public static void add(List<List<String>> list) throws ErrorMess{

		String sname; // 学生姓名
		int cid; // 班级ID
		int maxSid = -1;
		//System.out.println("enter");
		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = "select max(sid) AS maxSid from student";
			ResultSet rs = null;
			PreparedStatement ps = null;

			assert con != null;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()){
				maxSid = rs.getInt("maxSid");
				System.out.println(maxSid);
			}

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorMess("其他问题,请...");
		}

		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = "insert into student (sname, cid)  values (?,?)";
            assert con != null;
			PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			con.setAutoCommit(false);

			// 把list中的数据读出,并封装到stu里面,(list里面存放的是从Excel中读取出来的数据)
			for (List<String> cellList : list) {
				if (cellList.size() != 2) {
					throw new ErrorMess("数据格式错误,请核实检查!");
				}
				//读取该行每一列的相关信息
				sname = cellList.get(0);
				cid = (int) (Double.parseDouble(cellList.get(1)));

				ps.setString(1, sname);
				ps.setInt(2, cid);
				System.out.println(sname + " " + cid);
				ps.execute();


			}

			con.commit();
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
			String sql = "insert into user (account, password, type, ischeck)  values (?,?,?,?)";
			assert con != null;
			PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			con.setAutoCommit(false);

			// 把list中的数据读出,并封装到stu里面,(list里面存放的是从Excel中读取出来的数据)
			for (List<String> cellList : list) {

				maxSid++;

				if (cellList.size() != 2) {
					throw new ErrorMess("数据格式错误,请核实检查!");
				}

				ps.setString(1, String.valueOf(maxSid));
				ps.setString(2, "123");
				ps.setInt(3,1);
				ps.setInt(4,1);
				ps.execute();
			}

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
