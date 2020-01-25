package com.longyx.weixin.sell.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 0:13
 */
@SpringBootTest
@Slf4j
class LoggerTest {

    @Test
    void log(){
        String name="王怡";
        String gender="female";
        log.debug("debug...");
        log.info("name: "+name+" ,gender: "+gender);
        log.info("name: {} ,gender: {}",name,gender);
        log.error("error...");
        log.warn("warn...");
    }
}
