package com.longyx.weixin.sell.controller;

import com.longyx.weixin.sell.VO.ResultVO;
import com.longyx.weixin.sell.converter.OrderForm2OrderDTOConverter;
import com.longyx.weixin.sell.dto.OrderDTO;
import com.longyx.weixin.sell.enums.ResultEnum;
import com.longyx.weixin.sell.exception.SellException;
import com.longyx.weixin.sell.form.OrderForm;
import com.longyx.weixin.sell.service.BuyerService;
import com.longyx.weixin.sell.service.OrderService;
import com.longyx.weixin.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 21:30
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单
     * @author Mr.Longyx
     * @date 2020/1/20 22:03
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error(" 【创建订单】 参数不正确， orderForm = {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error(" 【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }
    /**
     * 订单列表
     * @author Mr.Longyx
     * @date 2020/1/20 22:48
     */
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid")String openid, @RequestParam(value = "page",defaultValue = "0")Integer page, @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error(" 【查询订单列表】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

     /**
      * 订单详情
      * @author Mr.Longyx
      * @date 2020/1/20 23:44
      * @param openid
      * @param orderId
      * @return com.longyx.weixin.sell.VO.ResultVO<com.longyx.weixin.sell.dto.OrderDTO>
      */
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId){
        OrderDTO orderDTO = buyerService.findByOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    /**
     * 取消订单
     * @author Mr.Longyx
     * @date 2020/1/20 23:56
     * @param openid
     * @param orderId
     * @return com.longyx.weixin.sell.VO.ResultVO
     */
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid")String openid,@RequestParam("orderId")String orderId){
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }
}
