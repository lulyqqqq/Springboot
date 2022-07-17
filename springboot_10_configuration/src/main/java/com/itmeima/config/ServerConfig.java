package com.itmeima.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @ClassName: ServletConfig
 * @author: mafangnian
 * @date: 2022/7/7 21:35
 * @Blog: null
 */

//定义数据模型封装yaml文件中对应的数据封装成对象
//定义spring管控的bean
//指定加载spring容器里自定义的bean
@ConfigurationProperties(prefix = "servers")
@Component
@Data
//2.开启对当前bean的属性注入校验
@Validated
public class ServerConfig {
    private String idAddress;
    //3.开启具体校验规则
    @Max(value = 8888,message = "最大值不超过8888")
    @Min(value = 202,message = "最小值不低于202")
    private int port;
    private long timeout;
    //默认时间单位为毫秒
    @DurationUnit(ChronoUnit.HOURS) //自定义时间单位
    private Duration serverTimeOut;
    //数据存储单位
    @DataSizeUnit(DataUnit.MEGABYTES) //自定义数据单位
    private DataSize dataSize;
}
