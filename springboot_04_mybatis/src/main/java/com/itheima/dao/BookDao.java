package com.itheima.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.itheima.domain.Book;


@Mapper
public interface BookDao {
    @Select("select * from tbl_book where id = #{id}")
    Book getById(int id);
}
