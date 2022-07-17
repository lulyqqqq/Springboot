package com.itheima;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot13MongdbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(1);
        book.setName("springboot");
        book.setType("math");
        book.setDescription("good book");
        mongoTemplate.save(book);
    }

    @Test
    void find() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }

}
