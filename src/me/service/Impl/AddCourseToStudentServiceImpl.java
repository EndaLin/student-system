package me.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import me.dao.impl.DBConnectionImpl;
import me.domain.ErrorMess;
import me.service.IAddCourseToStudentService;

public class AddCourseToStudentServiceImpl implements IAddCourseToStudentService{
	public static void add(List<List<String>> list) throws ErrorMess {

		try {
			Connection con = DBConnectionImpl.getConnection();
			String sql = "insert student_course (stu_id, cou_id, grade) values (?,?,?)";
			assert con != null;
			PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			con.setAutoCommit(false);

			// 把list中的数据读出,并封装到stu里面,(list里面存放的是从Excel中读取出来的数据)
			for (List<String> cellList : list) {

				if (cellList.size() != 3) {
					throw new ErrorMess("数据格式错误,请核实检查!");
				}
				// 读取该行每一列的相关信息
				int sid = (int) (Double.parseDouble(cellList.get(0)));
				int cid = (int) (Double.parseDouble(cellList.get(1)));
				int grade = (int) (Double.parseDouble(cellList.get(2)));
                System.out.println(sid + " " + cid + " " + grade);
				try {
					ps.setInt(1, sid);
					ps.setInt(2, cid);
					ps.setInt(3, grade);
					ps.execute();
				} catch (Exception e) {
					e.printStackTrace();
					throw new ErrorMess(sid + " " + cid + " " + grade + "已有该课程");
				}
			}

			con.commit();
			con.close();

		} catch (ErrorMess e) {
			throw e;
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new ErrorMess("没有该班级号");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorMess("其他问题,请...");
		}
	}
}
