package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SellerInfoServiceTest {
    private static final String openid = "love";

    @Autowired
    private SellerInfoService sellerInfoService;

    @Test
    void findSellerInfoByOpenid() {
        SellerInfo result = sellerInfoService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid, result.getOpenid());
    }
}