package com.itheima;

import com.itheima.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @ClassName: ConfigurationTest
 * @author: mafangnian
 * @date: 2022/7/8 15:11
 * @Blog: null
 */
@SpringBootTest
@Import(MsgConfig.class)
public class ConfigurationTest {

    @Autowired
    private  String msg;
    @Test
    void Configuration(){
        System.out.println(msg);
    }

}
