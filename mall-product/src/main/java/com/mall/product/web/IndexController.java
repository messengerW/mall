package com.mall.product.web;
/*
 * File: IndexController.java
 * Date: 2021-01-16 14:27
 * Author: msw
 * PS ...
 */

import com.mall.product.entity.CategoryEntity;
import com.mall.product.service.CategoryService;
import com.mall.product.vo.Catalog2Vo;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping({"/", "/index.html"})
    public String indexPage(Model model) {

        // 查出所有一级分类
        List<CategoryEntity> categoryEntities = categoryService.getLevel1Categorys();

        // 视图解析器（ViewResolver）进行拼串：前缀("classpath:/templates/") + 返回值 + 后缀(".html")
        model.addAttribute("categorys", categoryEntities);
        return "index";
    }

    /**
     * 获取2级3级分类的json
     * @return
     */
    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catalog2Vo>> getCatalogJson(){
        // 我发现一个问题:
        // 如果缓存命中的话，就不会再执行impl中的业务
        System.out.println("IndexController.getCatalogJson");
        Map<String, List<Catalog2Vo>> catalogJson = categoryService.getCatalogJson();
        System.out.println("After service.getCatalogJson invocation: " + catalogJson + "\n");
        return catalogJson;
    }

    /**
     * RLock锁有看门狗机制 会自动帮我们续期，默认三秒自动过期
     * lock.lock(10,TimeUnit.SECONDS); 十二猴子的时间一定要大于业务的时间 否则会出现死锁的情况
     * 如果我们传递了锁的超时时间就给redis发送超时脚本 默认超时时间就是我们指定的
     * 如果我们未指定，就使用 30 * 1000 [LockWatchdogTimeout]
     * 只要占锁成功 就会启动一个定时任务 任务就是重新给锁设置过期时间 这个时间还是 [LockWatchdogTimeout] 的时间 1/3 看门狗的时间续期一次 续成满时间
     */
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        // 获取一把锁（只要锁的名字一样，就是同一把锁）
        RLock lock = redissonClient.getLock("my-lock");
        // 加锁
        lock.lock();
        try {
            System.out.println("加锁成功，执行业务..." + Thread.currentThread().getId());
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            System.out.println("业务已结束，释放锁..." + Thread.currentThread().getId());
            lock.unlock();
        }
        return "hello";
    }

    /**
     * 读写锁
     *  - 修改数据时，加写锁
     *  - 读取数据时，加读锁
     */
    @GetMapping("/write")
    @ResponseBody
    public String writeValue() {
        RReadWriteLock lock = redissonClient.getReadWriteLock("rw-lock");
        RLock rLock = lock.writeLock();
        String s = "";
        try {
            rLock.lock();
            s = UUID.randomUUID().toString();
            Thread.sleep(3000);
            stringRedisTemplate.opsForValue().set("writeValue", s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
        return s;
    }

    @GetMapping("/read")
    @ResponseBody
    public String readValue() {
        RReadWriteLock lock = redissonClient.getReadWriteLock("rw-lock");
        RLock rLock = lock.readLock();
        String s = "";
        rLock.lock();
        try {
            s = stringRedisTemplate.opsForValue().get("writeValue");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
        return s;
    }

    /**
     * 闭锁 只有设定的人全通过才关门
     */
    @ResponseBody
    @GetMapping("/lockDoor")
    public String lockDoor() throws InterruptedException {
        RCountDownLatch door = redissonClient.getCountDownLatch("door");
        // 设置这里有5个人
        door.trySetCount(5);
        door.await();

        return "5个人全部通过了...";
    }

    @ResponseBody
    @GetMapping("/go/{id}")
    public String go(@PathVariable("id") Long id) throws InterruptedException {

        RCountDownLatch door = redissonClient.getCountDownLatch("door");
        // 每访问一次相当于出去一个人
        door.countDown();
        return id + "走了";
    }

    /**
     * 尝试获取车位 [信号量]
     * 信号量:也可以用作限流
     */
    @ResponseBody
    @GetMapping("/park")
    public String park() {

        RSemaphore park = redissonClient.getSemaphore("park");
        boolean acquire = park.tryAcquire();
        return "获取车位 =>" + acquire;
    }

    /**
     * 尝试获取车位
     */
    @ResponseBody
    @GetMapping("/go/park")
    public String goPark() {

        RSemaphore park = redissonClient.getSemaphore("park");
        park.release();
        return "ok => 车位+1";
    }

}
