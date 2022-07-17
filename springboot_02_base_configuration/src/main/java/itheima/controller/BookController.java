package itheima.controller;

import itheima.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: BookController
 * @author: mafangnian
 * @date: 2022/5/4 20:46
 * @Blog: null
 */
//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${country}")
    private String country1;

    @Value("${user.name}")
    private String name1;

    @Value("${likes[1]}")
    private String likes;

    //自动装配 yml配置文件里的全部属性
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById(){
        System.out.println("SpringBoot is running2.....");
        System.out.println("country1 is:"+country1);
        System.out.println("name1 is:"+name1);
        System.out.println("likes is:"+likes);
        System.out.println("--------------------------------");
        System.out.println(env.getProperty("user.name"));
        System.out.println(env.getProperty("likes[1]"));
        System.out.println("--------------------------------");
        System.out.println(myDataSource);
        return "SpringBoot is running2.....";
    }

}
