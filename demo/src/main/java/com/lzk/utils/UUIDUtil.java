package com.lzk.utils;

import java.util.UUID;

/**
 * @author lzk
 * @create 2018-08-21 0:05
 * Description: uuid工具类
 */
public class UUIDUtil {

    public static String getUUID36(){
        return UUID.randomUUID().toString();
    }

    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
