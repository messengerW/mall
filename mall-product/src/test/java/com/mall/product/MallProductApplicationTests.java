package com.mall.product;

import com.mall.product.entity.BrandEntity;
import com.mall.product.service.BrandService;
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
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    public void contextLoads() {

        BrandEntity entity = new BrandEntity();

        entity.setName("Huawei");
        brandService.save(entity);
        System.out.println("============Insert Successfully!============");
    }

    @Test
    public void testOSS() throws FileNotFoundException {
        /*
        * 对象存储操作步骤
        * 1. pom中引入oss-starter
        * 2. application.xml中配置access、secret、endpoint等信息
        * 3. 使用 OSSClient
        * */

        // 方法二：自己创建一个OSSClient对象
//        // Endpoint
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
//        String accessKeyId = "LTAI4G6MJHukz2549aDCMy1J";
//        String accessKeySecret = "bThPe7wGCoeRVnCKCRDR7sqpibt1n4";
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
//        InputStream inputStream = new FileInputStream("E:\\QQ\\File\\347888930\\FileRecv\\MobileFile\\wechat005.png");
//        ossClient.putObject("msw-mall", "exam1.png", inputStream);

        // 关闭OSSClient。
//        ossClient.shutdown();
//        System.out.println("上传成功...");
    }

}
