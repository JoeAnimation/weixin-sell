package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dto.OrderDTO;

/**
 * 微信公众平台推送模板消息
 * @author Mr.Longyx
 * @date 2020年01月25日 9:52
 */
public interface PushMessageService {
    /**
     * 订单状态变更信息
     * @author Mr.Longyx
     * @date 2020/1/25 9:55
     * @param orderDTO 
     */
    void orderStatus(OrderDTO orderDTO);
}
