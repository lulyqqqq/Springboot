package com.itheima.utlis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CodeUtils
 * @author: mafangnian
 * @date: 2022/7/12 15:45
 * @Blog: null
 */
@Component
public class CodeUtils {

    private String[] patch = {"000000","00000","0000","000","00","0",""};

    public String generator(String tele){
        int hash = tele.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String str = code +"";
        int len = str.length();
        return patch[len]+ code;
    }
    // 将获得内存中的验证码 拿出来返回
    // 现在使用@Cacheable必须放在spring的容器里才能获得这验证码
    @Cacheable(value = "smsCode",key = "#tele")
    public String get(String tele){
        return null;
    }

//    public static void main(String[] args) {
//        System.out.println(new CodeUtils().generator("18866668888"));
//    }


}
