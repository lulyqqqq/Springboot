package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: BookImpl
 * @author: mafangnian
 * @date: 2022/5/6 22:22
 * @Blog: null
 */
@Repository
public class BookImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao is running....");
    }
}
