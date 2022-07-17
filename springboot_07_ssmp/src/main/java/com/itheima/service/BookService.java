package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;

import java.util.List;

/**
 * @ClassName: BookService
 * @author: mafangnian
 * @date: 2022/5/7 19:30
 * @Blog: null
 */
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(int id);
    Book getById(int id);
    List<Book> getAll();
    IPage<Book> getPage(int current,int pageSize);
}
