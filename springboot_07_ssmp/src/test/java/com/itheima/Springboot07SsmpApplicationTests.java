package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import com.itheima.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot07SsmpApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private IBookService bookService;

    @Test
    void contextLoads() {
        System.out.println(bookService.getById(2));
    }

    //分页
    @Test
    void page() {

        IPage<Book> page = new Page<>(1,3);
        bookService.page(page);
        //打印当前页内数据
        System.out.println(page.getRecords());

    }

    //按条件查询
    @Test
    void testBy() {

        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(true,"name","学");
        bookDao.selectList(queryWrapper);

    }
    //按条件查询
    @Test
    void testBy2() {

        String name = null;
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name!=null,Book::getName,name);
        bookDao.selectList(lambdaQueryWrapper);

    }
}
