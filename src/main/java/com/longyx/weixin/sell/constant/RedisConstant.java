package com.longyx.weixin.sell.constant;

/**
 * redis常量配置
 * @author Mr.Longyx
 * @date 2020年01月24日 17:29
 */
public interface RedisConstant {
    String TOKEN_PREFIX = "token_%s";

    /**
     * 过期时间默认两天
     * @author Mr.Longyx
     * @date 2020/1/24 17:52
     */
    Integer EXPIRE = 7200;
}
