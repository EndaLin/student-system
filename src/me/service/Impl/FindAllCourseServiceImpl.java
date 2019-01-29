package me.service.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import me.dao.impl.DBConnectionImpl;
import me.domain.Course;

public class FindAllCourseServiceImpl {
	public static ArrayList<Course> find() {
        ArrayList<Course> courseArrayList = new ArrayList<Course>();

        try {
            Connection con = DBConnectionImpl.getConnection();
            String sql = "select * from course";
            Statement state = con.createStatement();

            //执行查询并返回结果集
            ResultSet rs = state.executeQuery(sql);

            while(rs.next()){  //通过next来索引：判断是否有下一个记录
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
}
