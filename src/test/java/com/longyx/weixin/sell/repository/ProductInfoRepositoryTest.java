package com.longyx.weixin.sell.repository;

import com.longyx.weixin.sell.dataobject.ProductCategory;
import com.longyx.weixin.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1589613");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(5.99));
        productInfo.setProductStock(50);
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("美味可口");
        productInfo.setProductIcon("http://www.product.com/cool.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    void findByProductStatus() {
        List<ProductInfo> productInfos = repository.findByProductStatus(0);
       Assert.assertNotEquals(0,productInfos.size());
    }
}