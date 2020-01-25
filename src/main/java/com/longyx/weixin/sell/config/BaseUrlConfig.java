package com.longyx.weixin.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Longyx
 * @date 2020年01月24日 19:21
 */
@Data
@Component
@ConfigurationProperties(prefix = "base-url")
public class BaseUrlConfig {
    /**
     * 微信公众平台授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统名称
     */
    public String sell;
}
