package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PayServiceTest {

    @Autowired
    private PayService payService;

    @Autowired
    private  OrderService orderService;

    @Test
    void create() {
       OrderDTO orderDTO = orderService.findById("6618369529938444288");
       payService.create(orderDTO);
    }

    @Test
    void refund(){
        OrderDTO orderDTO = orderService.findById("6618369529938444288");
        payService.refund(orderDTO);
    }
}