package com.mall.third;

import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallThirdApplicationTests {

    @Autowired
    OSSClient ossClient;

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
