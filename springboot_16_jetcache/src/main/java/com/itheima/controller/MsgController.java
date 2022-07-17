package com.itheima.controller;

import com.itheima.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: MsgController
 * @author: mafangnian
 * @date: 2022/7/12 13:39
 * @Blog: null
 */
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;


    @GetMapping("{tele}")
    public String get(@PathVariable String tele){
        return msgService.get(tele);
    }
    @PostMapping
    public boolean check(String tele, String code){
        return msgService.check(tele,code);
    }

}
