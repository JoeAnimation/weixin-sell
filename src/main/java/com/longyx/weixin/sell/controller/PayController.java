package com.longyx.weixin.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.longyx.weixin.sell.dto.OrderDTO;
import com.longyx.weixin.sell.enums.ResultEnum;
import com.longyx.weixin.sell.exception.SellException;
import com.longyx.weixin.sell.service.OrderService;
import com.longyx.weixin.sell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Mr.Longyx
 * @date 2020年01月21日 23:04
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId")String orderId, @RequestParam("returnUrl") String returnUrl, Map<String, Object> map) {
        //1.查询订单
        OrderDTO orderDTO = orderService.findById(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }
    /**
     * 微信异步通知
     * @author Mr.Longyx
     * @date 2020/1/22 23:00
     * @param notifyData 
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);

        //返回处理结果给微信
        return new ModelAndView("pay/success");
    }

}
