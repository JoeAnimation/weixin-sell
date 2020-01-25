package com.longyx.weixin.sell.service;

import com.longyx.weixin.sell.dto.OrderDTO;

/**
 * 买家
 * @author Mr.Longyx
 * @date 2020年01月21日 0:06
 */
public interface BuyerService {
    /**
     * 查询单个订单
     * @author Mr.Longyx
     * @date 2020/1/21 0:08
     * @param openid
     * @param orderId
     * @return com.longyx.weixin.sell.dto.OrderDTO
     */
    OrderDTO findByOrderOne(String openid, String orderId);

    /**
     * 取消订单
     * @author Mr.Longyx
     * @date 2020/1/21 0:08
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
