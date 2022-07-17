package com.itheima.service.impl;

import com.alicp.jetcache.anno.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

    @Autowired
    private BookDao bookDao;



    @Override
    //开启缓存，缓存空间为cacheSpace，查找条件为key=id 设置为本地
    @Cached(name="book_",key="#id",expire = 3600,cacheType = CacheType.REMOTE)
    @CacheRefresh(refresh = 10,timeUnit = TimeUnit.SECONDS)
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }
    //更新操作 更新时将缓存中对应的数据一起更新
    @CacheUpdate(name="book_",key="#book.id",value="#book")
    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book)>1;
    }
    //删除操作 删除时将缓存中对应的数据一起删除
    @CacheInvalidate(name = "book_",key="#id")
    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id)>1;
    }


    @Override
    public boolean save(Book book) {
        return bookDao.insert(book)>1;
    }
    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
