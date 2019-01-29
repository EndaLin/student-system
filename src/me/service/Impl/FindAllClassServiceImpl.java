package me.service.Impl;

import java.sql.*;
import java.util.ArrayList;

import me.dao.impl.DBConnectionImpl;
import me.domain.Classes;
import me.service.IFindAllClassService;

public class FindAllClassServiceImpl implements IFindAllClassService {
    public static ArrayList<Classes> find() {

        ArrayList<Classes> classesArrayList = new ArrayList<Classes>();

        try {

            Connection con = DBConnectionImpl.getConnection();
            String sql = "select * from class";
            Statement state = con.createStatement();

            //执行查询并返回结果集
            ResultSet rs = state.executeQuery(sql);

            while(rs.next()){  //通过next来索引：判断是否有下一个记录
                int cid = rs.getInt("cid");
                String name = rs.getString("cname");
                int grade = rs.getInt("cgrade");

                Classes classes = new Classes(cid, name, grade);
                classesArrayList.add(classes);
            }
            rs.close();
            state.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classesArrayList;
    }
}
