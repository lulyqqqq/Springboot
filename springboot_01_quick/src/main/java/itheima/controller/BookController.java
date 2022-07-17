package itheima.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName: BookController
 * @author: mafangnian
 * @date: 2022/5/4 20:46
 * @Blog: null
 */
@Slf4j
//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String getById(){
        System.out.println("SpringBoot is running.....");
        log.debug("debug...");
        log.info("info....");
        log.error("error...");
        log.warn("warn...");
        return "SpringBoot is running.....";
    }

}
