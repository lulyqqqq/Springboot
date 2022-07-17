package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.apache.ibatis.annotations.Delete;
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
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    //查全部
    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    //增加 请求体传参
    @PostMapping
    public R save(@RequestBody Book book){
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);

        return new R(bookService.save(book));
    }

    //修改 请求体传参
    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.modify(book));
    }

    //路径变量删除
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }

    //路径变量查单个
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    //分页
    @GetMapping("{current}/{pageSize}")
    public R getPage(@PathVariable int current,@PathVariable int pageSize){
        return new R(true,bookService.getPage(current,pageSize));
    }
}
