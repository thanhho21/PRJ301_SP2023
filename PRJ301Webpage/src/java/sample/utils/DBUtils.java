/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Thanh
 */

public class DBUtils {

    public static Connection getConnection1() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BabyShopManagement";
        conn = DriverManager.getConnection(url, "sa", "12345");
        return conn;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        Context context = new InitialContext();
        Context end = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) end.lookup("DBCon");
        Connection conn = ds.getConnection();
        return conn;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
        System.out.println("" + DBUtils.getConnection());

    }
    
    
}
