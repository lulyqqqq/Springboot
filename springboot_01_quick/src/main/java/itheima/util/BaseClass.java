package itheima.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: BaseClass
 * @author: mafangnian
 * @date: 2022/7/4 13:23
 * @Blog: null
 */
public class BaseClass {
    private Class clazz;
    public static  Logger log;

    public BaseClass(){
        clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }
}
