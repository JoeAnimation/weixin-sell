package com.longyx.weixin.sell.repository;

import com.longyx.weixin.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("587968139");
        orderDetail.setOrderId("22338876");
        orderDetail.setProductIcon("http://foods.delicious.com/cake.jpg");
        orderDetail.setProductId("6666999998888");
        orderDetail.setProductName("蛋糕");
        orderDetail.setProductPrice(new BigDecimal(5.66));
        orderDetail.setProductQuantity(120);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }
    @Test
    void findByOrderId() {
        List<OrderDetail> orderDetails = repository.findByOrderId("22338876");
        Assert.assertNotEquals(0,orderDetails.size());
    }
}