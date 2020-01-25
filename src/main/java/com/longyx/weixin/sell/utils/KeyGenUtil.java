package com.longyx.weixin.sell.utils;

import java.util.Random;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 15:47
 */
public class KeyGenUtil {
    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @author Mr.Longyx
     * @date 2020/1/20 16:06
     * @return java.lang.String
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}
