package com.dao;

import com.model.Book;
import com.model.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        //Log4j.getLogger().info("加载——CustomerDAO:");
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public List<Book> allBook(){
        System.out.println("allbook");
        String SQL = "select * from book";
        List <Book> book = new ArrayList<Book>();
        try{
            book= jdbcTemplateObject.query(SQL,
                    new BookMapper());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("allbook1");
        return book;
    }
    public static Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test"+"?serverTimezone=GMT%2B8";;
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
