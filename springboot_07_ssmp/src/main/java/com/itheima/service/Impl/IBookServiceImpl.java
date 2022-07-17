package com.itheima.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: IBookServiceImpl
 * @author: mafangnian
 * @date: 2022/5/7 19:50
 * @Blog: null
 */
@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean saveBook(Book book){
        return  bookDao.insert(book)>0;
    }

    @Override
    public boolean modify(Book book){
        return bookDao.updateById(book)>0;
    }

    @Override
    public boolean delete(Integer id){
        return bookDao.deleteById(id)>0;
    }

    @Override
    public IPage<Book> getPage(int current, int pageSize) {
        IPage page = new Page(current,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

}
