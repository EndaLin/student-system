package me.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.service.IModifyScoresByExcelService;

public class ModifyScoresByExcelServiceImpl implements IModifyScoresByExcelService {
	public static void modify(List<List<String>> list) throws ErrorMess {

		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = "update student_course set score = ? where stu_id = ? AND cou_id = ? AND grade = ?";
			assert con != null;
			PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			con.setAutoCommit(false);

			// 把list中的数据读出,并封装到stu里面,(list里面存放的是从Excel中读取出来的数据)
			for (List<String> cellList : list) {

				if (cellList.size() != 4) {
					throw new ErrorMess("数据格式错误,请核实检查!");
				}
				// 读取该行每一列的相关信息
				int sid = (int) (Double.parseDouble(cellList.get(0)));
				int cid = (int) (Double.parseDouble(cellList.get(1)));
				int grade = (int) (Double.parseDouble(cellList.get(2)));
				int score = (int) (Double.parseDouble(cellList.get(3)));
                System.out.println(sid + " " + cid + " " + score + " " + grade);
				ps.setInt(1, score);
				ps.setInt(2, sid);
				ps.setInt(3, cid);
				ps.setInt(4, grade);
				ps.execute();
			}

			con.commit();
			con.close();

		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorMess("其他问题,请...");
		}
	}
}
