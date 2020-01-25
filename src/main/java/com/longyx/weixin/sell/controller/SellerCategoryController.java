package com.longyx.weixin.sell.controller;

import com.longyx.weixin.sell.dataobject.ProductCategory;
import com.longyx.weixin.sell.exception.SellException;
import com.longyx.weixin.sell.form.CategoryForm;
import com.longyx.weixin.sell.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 卖家类目管理
 * @author Mr.Longyx
 * @date 2020年01月23日 20:14
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 类目列表
     * @author Mr.Longyx
     * @date 2020/1/23 20:17
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    /**
     * 展示
     * @author Mr.Longyx
     * @date 2020/1/23 20:18
     * @param categoryId
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId, Map<String, Object> map) {
        if (categoryId != null) {
            Optional<ProductCategory> productCategory = categoryService.findById(categoryId);
            map.put("category", productCategory.get());
        }

        return new ModelAndView("category/index", map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form, BindingResult bindingResult, Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        Optional<ProductCategory> productCategory = Optional.of(new ProductCategory());
        try {
            if (form.getCategoryId() != null) {
                productCategory = categoryService.findById(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, productCategory.get());
            categoryService.save(productCategory.get());
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}

