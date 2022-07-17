package com.itheima.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utlis.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SMSCodeServiceImpl
 * @author: mafangnian
 * @date: 2022/7/12 15:39
 * @Blog: null
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {
    @Autowired
    private CodeUtils codeUtils;

    // remote

    // 设置过期时间 默认为秒 设置本地访问:cacheType = CacheType.LOCAL
    @CreateCache(name="jetCache",expire = 3600,timeUnit =  TimeUnit.SECONDS,cacheType = CacheType.LOCAL)
    private Cache<String,String> jetCache;

    // 设置过期时间 默认为秒  方案2
//    @CreateCache(area = "sms",name="jetCache",expire = 10,timeUnit =  TimeUnit.SECONDS)
//    private Cache<String,String> jetCache1;


    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetCache.put(tele,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {

        String code = jetCache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }
}
