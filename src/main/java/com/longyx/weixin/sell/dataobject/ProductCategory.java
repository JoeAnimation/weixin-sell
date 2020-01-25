package com.longyx.weixin.sell.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 8:53
 */
@Data
@DynamicUpdate
@Entity
@TableName("product_category")
@NoArgsConstructor
@ToString
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 2942290201498439213L;
    /**
     * 类目id
     * @author Mr.Longyx
     * @date 2020/1/20 9:03
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 类目名字
     * @author Mr.Longyx
     * @date 2020/1/20 9:04
     */
    private String categoryName;

    /**
     * 类目编号
     * @author Mr.Longyx
     * @date 2020/1/20 9:04
     */
    private Integer categoryType;

    /**
     * 创建时间
     * private LocalDateTime createTime
     * @author Mr.Longyx
     * @date 2020/1/20 23:19
     */
    private Date createTime;

    /**
     * 更新时间
     * @author Mr.Longyx
     * @date 2020/1/23 20:24
     * @param null
     * @return null
     */
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType){
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
