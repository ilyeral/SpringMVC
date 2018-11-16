package com.controller;

import com.model.Book;
import com.model.Student;
import com.service.BookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/book")
public class controller {
    @Resource
    BookService bookService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    private String student(Model model) {//返回页面
        model.addAttribute("student", new Student());
        return "student";// WEB-INF/student.html
    }
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    @ResponseBody
    private String list(Model model) {//返回字符串
        return "result!!!!!!!!!!!!!!";
    }
}
