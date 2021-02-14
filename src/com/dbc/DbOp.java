package com.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DbOp {
    private static String driver = "com.mysql.cj.jdbc.Driver";//java8以上适用
    private static String dbName = "tickets";
    private static String userName = "root";
    private static String userPwd = "ljt123456";//删掉了密码
    private static String url = "jdbc:mysql://localhost:3306/"+dbName + "?useSSL=false&serverTimezone=UTC";
    private static Connection con = null;
    private DbOp() {
        try {
            if (con == null) {
                Class.forName(driver);
                con = DriverManager.getConnection(url,userName,userPwd);
            }
        } catch (Exception ignored) {
        }
    }

    public static ResultSet executeQuery(String sql) {
        try {
            // 如果未创建数据库连接，则创建连接
            if (con == null)
                new DbOp();
            // 返回查询结果
            return con.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }

    // 执行数据库更新操作。如果有问题，则返回-1
    public static int executeUpdate(String sql) {
        try {
            // 如果未创建数据库连接，则创建连接
            if (con == null)
                new DbOp();
            // 返回操作结果
            return con.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            return -1;
        }
    }

    // 关闭数据库
    public static void Close() {
        try {
            // 如果数据库已打开，则关闭之
            if (con != null)
                con.close();
        } catch (SQLException ignored) {
        }
    }
}