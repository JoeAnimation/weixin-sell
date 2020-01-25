package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dataobject.OrderDetail;
import com.longyx.weixin.sell.dto.OrderDTO;
import com.longyx.weixin.sell.enums.OrderStatusEnum;
import com.longyx.weixin.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    private final String OPENID = "hadoop999";

    private final String ORDERID = "668890301498130432";

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("王怡");
        orderDTO.setBuyerAddress("成都金牛区温馨小户人家");
        orderDTO.setBuyerPhone("18794362846");
        orderDTO.setBuyerOpenid("hadoop496");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("15896984");
        orderDetail.setProductQuantity(1);

        OrderDetail order = new OrderDetail();
        order.setProductId("15896795");
        order.setProductQuantity(1);

        orderDetailList.add(orderDetail);
        orderDetailList.add(order);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result = {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    void findById() {
        OrderDTO result = orderService.findById(ORDERID);
        log.info("【查询单个订单】 result = {}", result);
        Assert.assertEquals(ORDERID, result.getOrderId());
    }

    @Test
    void findList() {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(OPENID, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    void cancel() {
        OrderDTO orderDTO = orderService.findById(ORDERID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    void finish() {
        OrderDTO orderDTO = orderService.findById(ORDERID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    void pay() {
        OrderDTO orderDTO = orderService.findById(ORDERID);
        OrderDTO result = orderService.pay(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void list(){
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
//        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
        Assert.assertTrue("查询所有的订单列表", orderDTOPage.getTotalElements() > 0);
    }
}