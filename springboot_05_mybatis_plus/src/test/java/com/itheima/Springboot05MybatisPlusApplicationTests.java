package com.itheima;

import com.itheima.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisPlusApplicationTests {


    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        System.out.println("id:"+bookDao.selectById(1));
        System.out.println(bookDao.selectList(null));
    }

}
