package com.mall.third;

import com.aliyun.oss.OSSClient;
import com.mall.common.utils.HttpUtils;
import com.mall.third.component.SmsComponent;
import org.apache.http.HttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallThirdApplicationTests {

    @Autowired
    OSSClient ossClient;

    @Autowired
    SmsComponent smsComponent;

    @Test
    public void testSms1() {
        smsComponent.sendSmsCode("13777827742", "222333");
    }

    @Test
    public void testSms() {
        String host = "https://gyytz.market.alicloudapi.com";
        String path = "/sms/smsSend";
        String method = "POST";
        String appcode = "cdca144fd2274ac3856017d67478eb88";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", "13777827742");
        querys.put("param", "验证码:888888,姓名:张三");
        querys.put("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2");
        querys.put("templateId", "f5e68c3ad6b6474faa8cd178b21d3377");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testOSS() throws FileNotFoundException {
        // 上传文件流。
        InputStream inputStream = new FileInputStream("E:\\QQ\\File\\347888930\\FileRecv\\MobileFile\\wechat005.png");
        ossClient.putObject("msw-mall", "exam1.png", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
        System.out.println("上传成功...");
    }

}
