package com.dao;

import com.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<Student> allStudent(){
        List<Student> list=new ArrayList<Student>();
        Connection conn = getConn();
        String sql = "select * from student";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Student Student=new Student();
                Student.setId(rs.getInt(0));
                Student.setId(rs.getInt(1));
                list.add(Student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    private static Connection getConn() {
        String driver = "com.mysql.jc.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}