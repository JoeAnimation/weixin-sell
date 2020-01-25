package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dataobject.ProductInfo;
import com.longyx.weixin.sell.enums.ProductStatusEnum;
import com.longyx.weixin.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductInfoServiceTest {
    @Autowired
    private ProductInfoService productInfoService;

    @Test
    void findById() {
        Optional<ProductInfo> productInfo = productInfoService.findById("15896139");
        Assert.assertEquals("15896139",productInfo.get().getProductId());
    }

    @Test
    void findUpAll() {
        List<ProductInfo> productInfos = productInfoService.findUpAll();
        Assert.assertNotEquals(0, productInfos.size());
    }

    @Test
    void findAll() {
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("15889764");
        productInfo.setProductName("蜜汁鸡翅");
        productInfo.setProductPrice(new BigDecimal(19.99));
        productInfo.setProductStock(100);
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("好吃又美味的鸡翅");
        productInfo.setProductIcon("http://www.product.com/delicious.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale(){
        ProductInfo result = productInfoService.onSale("15889764");
        Assert.assertEquals(ProductStatusEnum.UP, result.getProductStatusEnum());
    }

    @Test
    public void offSale(){
        ProductInfo result = productInfoService.offSale("15889764");
        Assert.assertEquals(ProductStatusEnum.DOWN, result.getProductStatusEnum());
    }
}