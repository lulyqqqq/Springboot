package com.itheima.controller.utils;

import lombok.Data;

/**
 * @ClassName: R
 * @author: mafangnian
 * @date: 2022/5/7 21:58
 * @Blog: null
 */
@Data
public class R {
    private boolean flag;
    private Object data;
    R(){

    }
    public R(Boolean flag){
        this.flag =flag;
    }

    public R(Boolean flag,Object data){
        this.data = data;
        this.flag = flag;
    }
}
