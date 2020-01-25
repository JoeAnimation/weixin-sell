package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PushMessageServiceTest {

    @Autowired
    private PushMessageService messageService;

    @Autowired
    private OrderService orderService;

    @Test
    void orderStatus() {
        OrderDTO orderDTO = orderService.findById("668890301498130432");
        messageService.orderStatus(orderDTO);
    }
}