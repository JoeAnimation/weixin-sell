package com.longyx.weixin.sell.controller;

import com.longyx.weixin.sell.VO.ProductDetailVO;
import com.longyx.weixin.sell.VO.ProductInfoVO;
import com.longyx.weixin.sell.VO.ResultVO;
import com.longyx.weixin.sell.dataobject.ProductCategory;
import com.longyx.weixin.sell.dataobject.ProductInfo;
import com.longyx.weixin.sell.service.CategoryService;
import com.longyx.weixin.sell.service.ProductInfoService;
import com.longyx.weixin.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @author Mr.Longyx
 * @date 2020年01月20日 11:44
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
//    @Cacheable(cacheNames = {"product"},key = "weixin")
    @Cacheable(cacheNames = {"product"}, key = "#sellerId", condition = "#sellerId.length() > 3", unless = "#result.getCode() != 0")
    public ResultVO list(@RequestParam("sellerId")String sellerId) {
        //1.查询所有的上架商品
        List<ProductInfo> productInfos = productInfoService.findUpAll();
        //2.查询类目(一次性查询)
        /*
         * List<Integer> categoryTypeList = new ArrayList<>();
         * 传统方法
         *   for(ProductInfo productInfo : productInfos){
         *   categoryTypeList.add(productInfo.getCategoryType());
         * }
         * @author Mr.Longyx
         * @date 2020/1/20 12:54
         * @return com.longyx.weixin.sell.VO.ResultVO
         */
        //lambda表达式
        List<Integer> categoryTypes = productInfos.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypes);
        //3.数据拼装
        List<ProductDetailVO> productDetailVOS = new ArrayList<>();
        for(ProductCategory productCategory : productCategories){
            ProductDetailVO productDetailVO = new ProductDetailVO();
            productDetailVO.setCategoryName(productCategory.getCategoryName());
            productDetailVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOS = new ArrayList<>();
            for(ProductInfo productInfo : productInfos){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            productDetailVO.setProductInfoVOList(productInfoVOS);
            productDetailVOS.add(productDetailVO);
        }

        return ResultVOUtil.success(productDetailVOS);
    }
}
