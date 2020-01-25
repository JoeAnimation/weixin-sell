package com.longyx.weixin.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Mr.Longyx
 * @date 2020年01月21日 17:06
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**公众平台id*/
    private String mpAppId;
    /**公众平台密钥*/
    private String mpAppSecret;
    /**开放平台id*/
    private String openAppId;
    /**开放平台密钥*/
    private String openAppSecret;
    /**商户号*/
    private String mchId;
    /**商户密钥*/
    private String mchKey;
    /**商户证书路径*/
    private String keyPath;

    /**微信异步通知回调地址*/
    private String notifyUrl;

    /**
     * 微信模板消息id
     * @author Mr.Longyx
     * @date 2020/1/25 11:09
     */
    private Map<String, String> templateId;
}
