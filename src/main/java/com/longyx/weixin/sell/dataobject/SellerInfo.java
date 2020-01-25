package com.longyx.weixin.sell.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr.Longyx
 * @date 2020年01月23日 20:57
 */
@Data
@Entity
@TableName("seller_info")
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class SellerInfo implements Serializable {
    private static final long serialVersionUID = -1916552771031621608L;
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

    private Date createTime;

    private Date updateTime;
}
