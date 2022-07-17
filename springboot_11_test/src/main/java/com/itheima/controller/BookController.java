package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: BookController
 * @author: mafangnian
 * @date: 2022/7/8 15:33
 * @Blog: null
 */
@RestController
@RequestMapping("/books")
public class BookController {

//    @GetMapping
//    public String getById(){
//        System.out.println("getById is running...");
//        return "springboot";
//    }

    @GetMapping
    public Book getById(){
        System.out.println("getById is running...");
        Book book = new Book();
        book.setId(1);
        book.setName("springboot");
        book.setType("math");
        book.setDescription("good book");
        return book;
    }
}
