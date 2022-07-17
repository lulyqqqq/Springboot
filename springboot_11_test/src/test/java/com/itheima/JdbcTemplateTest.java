package com.itheima;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: JdbcTemplateTest
 * @author: mafangnian
 * @date: 2022/7/9 12:59
 * @Blog: null
 */
@SpringBootTest
public class JdbcTemplateTest {

    //由springboot容器注入JdbcTemplate数据源
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //查询 查询格式对于方法架构
    @Test
    void testJdbc(){
        String sql = "select * from tbl_book where id =1";
        List<Book> qurey = jdbcTemplate.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs,int rowNum)throws SQLException{
                Book temp = new Book();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setType(rs.getString("Type"));
                temp.setDescription(rs.getString("description"));
                return temp;
            }
        });
        System.out.println(qurey);
    }
    //添加操作
    @Test
    void save(){
        String sql = "Insert into tbl_book values(null,'1','2''3')";
        jdbcTemplate.update(sql);
    }
}
