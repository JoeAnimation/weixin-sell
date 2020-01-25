package com.longyx.weixin.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableCaching
public class WeixinSellApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinSellApplication.class, args);
    }

}
