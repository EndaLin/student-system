package me.service.Impl;

import me.dao.impl.DBConnectionImpl;
import me.domain.Classes;
import me.service.FindClassSizeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/2/21 14:52
 */
public class FindClassSizeServiceImpl implements FindClassSizeService {
    @Override
    public List<Classes> check() {
        String sql = "SELECT COUNT(*) num, cname, grade\n" +
                "FROM select_course\n" +
                "GROUP BY cid,cname, grade";
        Connection connection = DBConnectionImpl.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Classes> listClass = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int num = resultSet.getInt("num");
                String cname = resultSet.getString("cname");
                int grade = resultSet.getInt("grade");
                listClass.add(new Classes(0, cname, grade, num));
            }
            return  listClass;
        } catch (Exception e) {
            e.printStackTrace();
            return listClass;
        } finally {
            DBConnectionImpl.free(connection, preparedStatement, resultSet);
        }
    }
}
