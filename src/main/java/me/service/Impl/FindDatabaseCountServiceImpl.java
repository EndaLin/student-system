package me.service.Impl;

import me.dao.impl.DBConnectionImpl;
import me.domain.Classes;
import me.domain.Message;
import me.domain.Student;
import me.service.FindDatabaseCountService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wt
 * @Date: 2019/2/19 10:22
 */
public class FindDatabaseCountServiceImpl implements FindDatabaseCountService {

    private final String[] NAME = {"class", "course", "student", "student_course", "user", "select_course", "student_class"};

    private final String PAGE_SIZE = "10";

    @Override
    public Message check(String id) {
        StringBuffer sql = new StringBuffer("select count(*) counts from ");
        sql.append(NAME[Integer.parseInt(id)]);
        Connection connection = DBConnectionImpl.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Message message = new Message();
        Map<String, Object> map = new HashMap<>();
        map.put("current", "1");
        map.put("page_size", PAGE_SIZE);
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                map.put("total", Integer.parseInt(resultSet.getString("counts")));
            } else {
                map.put("total", 0);
            }
            int pages = (int)map.get("total") % 10 == 0 ? (int)map.get("total") / 10 : (int)map.get("total") / 10 + 1;
            map.put("pages", String.valueOf(pages));
            message.setCode(0);
            message.setDetail("查询成功");
            message.setMessage(map);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            message.setDetail("服务器异常");
            return message;
        } finally {
            DBConnectionImpl.free(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Classes> findByCurrentPages(String id, String current) {
        int start = (Integer.parseInt(current) - 1) * Integer.parseInt(PAGE_SIZE);
        StringBuffer sql = new StringBuffer("select * from ");
        sql.append(NAME[Integer.parseInt(id)] + " order by cid desc limit ?,?");
        Connection connection = DBConnectionImpl.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Classes> listClasses = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, Integer.parseInt(PAGE_SIZE));
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int cid = resultSet.getInt("cid");
                String name = resultSet.getString("cname");
                int grade = resultSet.getInt("cgrade");

                Classes classes = new Classes(cid, name, grade);
                listClasses.add(classes);
            }
            return listClasses;
        } catch (Exception e) {
            e.printStackTrace();
            return listClasses;
        } finally {
            DBConnectionImpl.free(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public Message checkForStudent(String id) {
        StringBuffer sql = new StringBuffer("select count(*) counts from student where cid like ?");
        Connection connection = DBConnectionImpl.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Message message = new Message();
        Map<String, Object> map = new HashMap<>();
        map.put("current", "1");
        map.put("page_size", PAGE_SIZE);
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                map.put("total", Integer.parseInt(resultSet.getString("counts")));
            } else {
                map.put("total", 0);
            }
            int pages = (int)map.get("total") % 10 == 0 ? (int)map.get("total") / 10 : (int)map.get("total") / 10 + 1;
            map.put("pages", String.valueOf(pages));
            message.setCode(0);
            message.setDetail("查询成功");
            message.setMessage(map);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            message.setDetail("服务器异常");
            return message;
        } finally {
            DBConnectionImpl.free(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Student> findByCurrentPages2(String id, String current){
        int start = (Integer.parseInt(current) - 1) * Integer.parseInt(PAGE_SIZE);
        StringBuffer sql = new StringBuffer("select * from student_class where cid like ? order by sid desc limit ?,?");
        Connection connection = DBConnectionImpl.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> listStudent = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, id);
            preparedStatement.setInt(2, start);
            preparedStatement.setInt(3, Integer.parseInt(PAGE_SIZE));
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int sid = resultSet.getInt("sid");
                String name = resultSet.getString("sname");
                int cid = resultSet.getInt("cid");
                String cname = resultSet.getString("cname");
                int cgrade = resultSet.getInt("cgrade");

                Student student = new Student(sid, name, cid, cname, cgrade);
                listStudent.add(student);
            }
            return listStudent;
        } catch (Exception e) {
            e.printStackTrace();
            return listStudent;
        } finally {
            DBConnectionImpl.free(connection, preparedStatement, resultSet);
        }
    }
}
