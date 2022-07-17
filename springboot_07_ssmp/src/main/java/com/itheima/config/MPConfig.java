package com.itheima.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MPConfig
 * @author: mafangnian
 * @date: 2022/5/7 19:08
 * @Blog: null
 */

@Configuration
public class MPConfig {

    //使用拦截器创建分页
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //定义MP拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加具体的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return  interceptor;
    }
}
