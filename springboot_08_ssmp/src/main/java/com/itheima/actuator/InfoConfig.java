package com.itheima.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: InfoConfig
 * @author: mafangnian
 * @date: 2022/7/16 18:21
 * @Blog: null
 */
@Component
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("runTime",System.currentTimeMillis());

    }
}
