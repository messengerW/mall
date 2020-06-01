package com.mall.product;

import com.mall.product.entity.BrandEntity;
import com.mall.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallProductApplicationTests {

	@Autowired
	BrandService brandService;

	@Test
    public void contextLoads() {

//		BrandEntity entity = new BrandEntity();
//
//		entity.setName("Huawei");
//		brandService.save(entity);
//		System.out.println("============Insert Successfully!============");
	}

}
