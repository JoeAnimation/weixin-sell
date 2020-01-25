package com.longyx.weixin.sell.form;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年01月23日 20:19
 */
@Data
@ToString
public class CategoryForm implements Serializable {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
