package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

    @Autowired
    private BookDao bookDao;

//    //模拟缓存
//    private HashMap<Integer,Book> cache = new HashMap<>();
//
//    @Override
//    public Book getById(Integer id) {
//        //如果当前缓存中没有本次查询的数据，则在数据库中进行查询，否则直接在缓存中读取返回
//        Book book = cache.get(id);
//        if (book==null){
//            Book queryBook = bookDao.selectById(id);
//            cache.put(id,queryBook);
//            return queryBook;
//        }
//        return cache.get(id);
//    }

    @Override
    //开启缓存，缓存空间为cacheSpace，查找条件为key=id
    @Cacheable(value = "cacheSpace",key ="#id")
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book)>1;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book)>1;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id)>1;
    }



    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
