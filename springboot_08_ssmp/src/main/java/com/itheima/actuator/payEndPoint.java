package com.itheima.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: payEndPoint
 * @author: mafangnian
 * @date: 2022/7/16 20:17
 * @Blog: null
 */
@Component
@Endpoint(id = "pay",enableByDefault = true)
public class payEndPoint {
    @ReadOperation
    public Object getPay(){
        Map payMap = new HashMap();
        payMap.put("lever 1",100);
        payMap.put("lever 2",50);
        payMap.put("lever 3",10);
        return payMap;
    }
}
