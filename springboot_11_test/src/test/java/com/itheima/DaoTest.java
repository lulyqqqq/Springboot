package com.itheima;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: DaoTest
 * @author: mafangnian
 * @date: 2022/7/8 21:25
 * @Blog: null
 */
@SpringBootTest
@Transactional //操作事务的注解
@Rollback //默认回滚 不将测试数据添加到数据库
public class DaoTest {

    @Autowired
    private BookService bookService;

    @Test
    void DaoTest(){
        Book book = new Book();
//        book.setId(1);
        book.setName("springboot");
        book.setType("math");
        book.setDescription("good book");
        bookService.save(book);
    }
}
