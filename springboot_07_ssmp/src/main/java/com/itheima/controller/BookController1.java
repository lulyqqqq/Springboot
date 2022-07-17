package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: BookController
 * @author: mafangnian
 * @date: 2022/5/7 20:17
 * @Blog: null
 */
@RestController
//@RequestMapping("/books")
public class BookController1 {
    @Autowired
    private IBookService bookService;

    //查全部
    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    //增加 请求体传参
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    //修改 请求体传参
    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.modify(book);
    }

    //路径变量删除
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable int id){
        return bookService.delete(id);
    }

    //路径变量查单个
    @GetMapping("{id}")
    public Book getById(@PathVariable int id){
        return bookService.getById(id);
    }

    //分页
    @GetMapping("{current}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int current,@PathVariable int pageSize){
        return bookService.getPage(current,pageSize);
    }
}
