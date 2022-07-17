package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName: book
 * @author: mafangnian
 * @date: 2022/5/6 23:56
 * @Blog: null
 */
@Data
@TableName("tbl_book")
public class Book {
    private int id;
    private String type;
    private String name;
    private String description;

}
