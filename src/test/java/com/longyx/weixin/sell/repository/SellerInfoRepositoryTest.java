package com.longyx.weixin.sell.repository;

import com.longyx.weixin.sell.dataobject.SellerInfo;
import com.longyx.weixin.sell.utils.SnowflakeIdWorkerUtil;
import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void save(){
        SnowflakeIdWorkerUtil idWorker = new SnowflakeIdWorkerUtil(0, 0);

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(String.valueOf(idWorker.nextId()));
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("hadoop");
        sellerInfo.setOpenid("love");

        SellerInfo result = sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    void findByOpenid() {
        SellerInfo sellerInfo = sellerInfoRepository.findByOpenid("love");
        Assert.assertEquals("love", sellerInfo.getOpenid());
    }
}