package com.service;

import com.dao.BookDao;
import com.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    // 注入Service依赖
    @Autowired
    private BookDao bookDao;
    public  List<Book> getbook(){
        return bookDao.allBook();
    }
}