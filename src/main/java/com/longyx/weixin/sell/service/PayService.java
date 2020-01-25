package com.longyx.weixin.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.longyx.weixin.sell.dto.OrderDTO;

/**
 * 支付
 * @author Mr.Longyx
 * @date 2020年01月21日 23:09
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    /**退款*/
    RefundResponse refund(OrderDTO orderDTO);
}
