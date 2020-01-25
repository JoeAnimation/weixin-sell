package com.longyx.weixin.sell.controller;

import com.longyx.weixin.sell.dataobject.OrderDetail;
import com.longyx.weixin.sell.dto.OrderDTO;
import com.longyx.weixin.sell.enums.ResultEnum;
import com.longyx.weixin.sell.exception.SellException;
import com.longyx.weixin.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 卖家端信息
 * @author Mr.Longyx
 * @date 2020年01月23日 13:37
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @author Mr.Longyx
     * @date 2020/1/23 13:57
     * @param page 第几页，从第一页开始
     * @param size 每页显示的数据量
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page, @RequestParam(value = "size",defaultValue = "10")Integer size, Map<String, Object> map){
        PageRequest request = PageRequest.of(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size" , size);
        return new ModelAndView("order/list",map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findById(orderId);
            //取消订单
            orderService.cancel(orderDTO);
        }catch (SellException e){
            log.error(" 【卖家端取消订单】 该订单不存在");
            map.put("msg", e.getMessage());
            map.put("url" , "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg" , ResultEnum.ORDER_CANCEL_SUCCESS.getMsg());
        map.put("url" , "/sell/seller/order/list");

        return new ModelAndView("common/success");
    }

    /**
     * 订单详情
     * @author Mr.Longyx
     * @date 2020/1/23 15:31
     * @param orderId
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId")String orderId,Map<String, Object> map){
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderService.findById(orderId);
        }catch (SellException e){
            log.error(" 【卖家端查询订单详情】 发生异常 {}", e);
            map.put("msg" , e.getMessage());
            map.put("url" , "/sell/seller/order/list");

            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO" , orderDTO);
        return new ModelAndView("order/detail", map);
    }
    /**
     * 完结订单
     * @author Mr.Longyx
     * @date 2020/1/23 16:02
     * @param orderId
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId")String orderId, Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findById(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端完结订单】发生异常 {}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMsg());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
