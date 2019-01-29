package me.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public interface IDBConnectionDao {

    /*  创建数据库的连接*/
    static Connection getConnection() {
        return null;
    }

    /*关闭数据库连接并且释放资源*/
    static void free(Connection con, PreparedStatement ps, ResultSet rs) {
    }
}
