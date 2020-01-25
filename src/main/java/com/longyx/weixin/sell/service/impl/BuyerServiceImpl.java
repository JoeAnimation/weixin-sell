package com.longyx.weixin.sell.service.impl;

import com.longyx.weixin.sell.dto.OrderDTO;
import com.longyx.weixin.sell.enums.ResultEnum;
import com.longyx.weixin.sell.exception.SellException;
import com.longyx.weixin.sell.service.BuyerService;
import com.longyx.weixin.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Longyx
 * @date 2020年01月21日 0:09
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findByOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderForUser(openid, orderId);
        return orderDTO;
    }

    private OrderDTO checkOrderForUser(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findById(orderId);
        if(orderDTO == null){
            return null;
        }
        //判断订单和用户的匹配度
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error(" 【查询订单】 订单的openid不正确， openid = {}, orderDTO = {}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderForUser(openid, orderId);
        if (orderDTO == null){
            log.error(" 【取消订单】 查不到该订单， orderId = {}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
}
