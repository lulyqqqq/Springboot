package com.itheima.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: HealthConfig
 * @author: mafangnian
 * @date: 2022/7/16 19:57
 * @Blog: null
 */
@Component
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.withDetail("runTime",System.currentTimeMillis());
        Map infoMap = new HashMap();
        infoMap.put("buildTime","2006");
        builder.withDetails(infoMap);
        //设置状态
        builder.up();
    }
}
