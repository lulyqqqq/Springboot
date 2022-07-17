package itheima;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyDataSource
 * @author: mafangnian
 * @date: 2022/5/6 21:50
 * @Blog: null
 */
//定义数据模型封装yaml文件中对应的数据封装成对象
//定义spring管控的bean



@Data
@Component
//指定加载spring容器的数据
@ConfigurationProperties(prefix = "datasource")
public class MyDataSource {
    private String driver;
    private String url;
    private String username;
    private String password;
}
