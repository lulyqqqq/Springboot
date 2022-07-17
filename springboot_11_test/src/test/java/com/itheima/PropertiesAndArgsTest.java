package com.itheima;

import com.itheima.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName: PropertiesAndArgsTest
 * @author: mafangnian
 * @date: 2022/7/8 14:51
 * @Blog: null
 */
// 配置临时变量属性 里面是数组类型可以添加多条
// properties 可以为当前属性添加一组临时属性配置
@SpringBootTest(properties = {"test.prop=vtb1"})
//使用args配置临时属性 模拟命令行模式 注意前面得加--
//@SpringBootTest(args = {"--test.prop=vtb2"})
//当两个同时出现，由properties覆盖配置文件属性,再由命令行取代properties
//@SpringBootTest(properties = {"test.prop=vtb1"},args = {"--test.prop=vtb2"})
public class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String msg;

    @Autowired
    private BookCase bookCase;

    @Test
    void testProperties(){
        System.out.println(bookCase);
        System.out.println(msg);

    }
}
