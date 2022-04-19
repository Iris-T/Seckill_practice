package cn.iris.seckill.util;

import java.util.UUID;

/**
 * UUID工具类
 * @author Iris 2022/4/19
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
