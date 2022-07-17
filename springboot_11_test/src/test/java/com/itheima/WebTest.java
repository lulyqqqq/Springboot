package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * @ClassName: WebTest
 * @author: mafangnian
 * @date: 2022/7/8 15:26
 * @Blog: null
 */
//设置web环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 开启虚拟MVC调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    void testStatus(@Autowired MockMvc mvc)throws Exception{
        //创建一个虚拟请求,当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/1books");
        //执行对应请求
        ResultActions actions = mvc.perform(builder);
        //设置预期值,与真实值进行比较,成功测试通过,失败测试失败\
        //定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //定义具体的结果 预计本次调用时成功的状态:200
        ResultMatcher ok = status.isOk();
        //添加预期值到本次调用过程中进行匹配
        actions.andExpect(ok);
    }

    @Test
    void testBody(@Autowired MockMvc mvc)throws Exception{
        //创建一个虚拟请求,当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/1books");
        //执行对应请求
        ResultActions actions = mvc.perform(builder);


        //设置预期值,与真实值进行比较,成功测试通过,失败测试失败
        //定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //定义具体的结果 预计本次调用时成功返回内容
        ResultMatcher result = content.string("springboot");
        //添加预期值到本次调用过程中进行匹配
        actions.andExpect(result);
    }

    @Test
    void testBodyJson(@Autowired MockMvc mvc)throws Exception{
        //创建一个虚拟请求,当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/1books");
        //执行对应请求
        ResultActions actions = mvc.perform(builder);


        //设置预期值,与真实值进行比较,成功测试通过,失败测试失败
        //定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //定义具体的结果 预计本次调用时成功返回内容
        ResultMatcher result = content.json("id1\n" +
                "namespringboot\n" +
                "typemath\n" +
                "descriptiongood book");
        //添加预期值到本次调用过程中进行匹配
        actions.andExpect(result);
    }

    @Test
    void testContentType(@Autowired MockMvc mvc)throws Exception{
        //创建一个虚拟请求,当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/1books");
        //执行对应请求
        ResultActions actions = mvc.perform(builder);


        //设置预期值,与真实值进行比较,成功测试通过,失败测试失败
        //定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        //匹配响应头,name为响应头名称,value为预期结果
        ResultMatcher string = header.string("Content-Type", "application/json");
        //添加预期值到本次调用过程中进行匹配
        actions.andExpect(string);
    }
}
