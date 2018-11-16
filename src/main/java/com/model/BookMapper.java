package com.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper  implements RowMapper<Book> {
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setName(rs.getString("name"));
        book.setStudent_id(rs.getInt("student_id"));
        return book;
    }
}