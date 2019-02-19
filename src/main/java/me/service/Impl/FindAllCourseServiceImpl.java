package me.service.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import me.dao.impl.DBConnectionImpl;
import me.domain.Classes;
import me.domain.Course;

public class FindAllCourseServiceImpl {

    private static final String PAGE_SIZE = "10";

	public static ArrayList<Course> find() {
        ArrayList<Course> courseArrayList = new ArrayList<>();

        try {
            Connection con = DBConnectionImpl.getConnection();
            String sql = "select * from course order by id desc";
            Statement state = con.createStatement();

            //执行查询并返回结果集
            ResultSet rs = state.executeQuery(sql);

            //通过next来索引：判断是否有下一个记录
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");

                Course course = new Course(id, name);
                courseArrayList.add(course);
            }
            rs.close();
            state.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courseArrayList;
	}

	public List<Course> findByCurrentPage(String current) {
        List<Course> courseArrayList = new ArrayList<>();
        int start = (Integer.parseInt(current) - 1) * Integer.parseInt(PAGE_SIZE);
        StringBuffer sql = new StringBuffer("select * from course order by id desc limit ?,?");
        Connection connection = DBConnectionImpl.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, Integer.parseInt(PAGE_SIZE));
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                courseArrayList.add(new Course(id, name));
            }
            return courseArrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return courseArrayList;
        } finally {
            DBConnectionImpl.free(connection, preparedStatement, resultSet);
        }
    }
}
