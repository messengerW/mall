package com.mall.order.config;
/*
 * File: AlipayTemplate.java
 * Date: 2021-03-02 16:25
 * Author: msw
 * PS ...
 */

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mall.order.vo.PayVo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private String app_id = "2016110300789403";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCY61DLyr91aTittieabOf5atXpOZ6ukK4lT3uqFXzeFwPMcmUHdRGIhFdbq9Z6EjEAk7KiPhQwsZ+878k29Lvxzq6/8oQSHsRWGvbvE5cGaKVDapndyEZysfLhGzaHGdmmzOLbYHRl5vugA5enbTe1AbRSDdP9X7zWrW8R932F/uO+Uv95sYhv0F+gk9u+61ErnKsIO7Qza4JPFCLeOxdvURFyRcJuy4ibuuaAooqbD8GGUURq6W6/Am0O1KxAARvGRtnDjmAAhVYFwGEMiXyAxh1NqnDaaJQchI10gOWwPtK8Oim+VYtMe3zwyK8yer81q7kCp0Jm80HFFvMY3MaRAgMBAAECggEAXPR+MsNWSurhV0cpH8gf4w+8ZH9wJDEyit+cDrHtK5vV5UuMelIBjHjWGZWFVMMGIpGlvtX5s/flYBZqvAtczAqVU3z6J4GoW6ccgAvqfCzUePyt95Essb/WIlxGcy2Vjr1xEWW6m88jGgvU/iN3/4G/uTlKqfSud9kJcWR+Wxq5IIwrRoVTucRVYOuhL8FiJA/O5VyT4C5aVd4oK/Elh9GprpjL7yn66vkptun9DdOeV3mZ7od9t61D8ihDFXG5gm/X0HHL6PsMFJQwwjdGL8FlpDG0VPtqI/Vq6zktdhMAdrZmQNWbwHnVHJRCpd3SjFX3OcYLRKCcSf2P93E6GQKBgQDkCi7XfIWrFirzqq+rJvDRDShyu3quqK2V6f3T6kYQysUngLl6Y+BbgDjaEh5pm95AlgDD5jyw6kTOFvyC7mOXft8ect0UHNjV9SwW3OIc4Y8Jmq8dWASTIMocbyQ9RLMn0C6otAa49uCUNAKjuagGWPvt/8vaBAuUnMAZiQnliwKBgQCrqzatWannM19VBj7cP+ZWFV4vczk7VfUBBV/wA6QZl+R3ucekQaFhEzR+r5nPfYZTfKIuPRRnkspfZIuyUtS/qs6fpJSVKrAoAUID5Uqn/4Fg529nDYqarBL5P6HtEVWEvY2ztT22NqxDFazfY3xXP+1K+w+A1uiLYObvOVJf0wKBgHXwik9qmJtmqKpDYf2L80q7mmrUadwBY13AmkXKyZgPty36FnOlSjkotL6cVlxaf/U5X4XyAvug/hr0qn5xGtMUjALsd0jaro7h8X6VmOBFDDx0YxMzHZKWh9Fy7fQ+HsZ9llQsX7mz/WzJBYB2Gd/Gj+2EuYK1SuP+uh+6z4KHAoGAevadqJfEIo5ip8Vce2jt9RVDLJvND9pnLz8JVCNXhNmO1c9l2BsGnEEkZeYkN0KDWAO7K4GmvvWfLasYgTfhmhSgAiviHeLA4TbdcWrpCeLzalT8MAW8FURSJuTUeLnk1rrr6CBXPtB0nWzGMhDRvLFWqFGi7jeBxGw5nnshrO8CgYB7QClOaYpcqpcLu7OHm9lACvihYZb9TlfUWhkIQBZYQ+7ARjcrTf5bAx5mLcLws2h/EUFF9nctEz2CffkLUZh5shGapqosmHXDmkpzFA6/QtOKW7xXBG+GJrBZ8m1AI7PvIfl/mSehLQtU5HXkWK7k4M2Ll9LZSIaMhtYEPFv0IA==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgjIlPCM9fPAKKEg+1ICyoL3Tn0iTiYaQtjgHRewrBLa1NwDTvuN3kSHKjAmqlGVt0oqeRUfGzNfPy3Mngjpj1/La8JUndk/T5TEiJCFUEJ7f/CmPTG17D9NiqAxbxMPjt7dgxzC0EzpO+9OZRMSsV/uq1gT+kymrgok5yefQi4ONvopUG45XaBCfzEz3qvenlAIJf6dAgA5ZVtYOn62J4Nf/z6fB8rqCnAN+QxzO9EIngAuTaM/55xeQc/wUVYttYL/t5Mgaz3Uv9tMZzmWfZ4h/pBD9HK4DS2c13gdk9NN0si7YUpEIHyJsH9yZZbT9gzGJwIHNC/7d0OYVI6kKrwIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    private String notify_url = "http://s4nhit.natappfree.cc/payed/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    private String return_url = "http://member.echoone.cn/memberOrder.html";

    // 签名方式
    private String sign_type = "RSA2";

    // 字符编码格式
    private String charset = "utf-8";

    // 自动关单时间
    private String timeout = "15m";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public String pay(PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        // 30分钟内不付款就会自动关单
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\"" + timeout + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面
        return result;
    }
}