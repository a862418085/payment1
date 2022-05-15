package com.atguigu.paymentdemo.controller;

import com.atguigu.paymentdemo.entity.Product;
import com.atguigu.paymentdemo.service.ProductService;
import com.atguigu.paymentdemo.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@CrossOrigin  //开放前端的跨域访问  不同端口号
@Api(tags = "商品管理")/*添加swagger设置*/
@RestController
@RequestMapping("/api/product")
public class ProductContoller {
    @Resource
    private ProductService productService;
    @ApiOperation("测试接口")
    @GetMapping("/test")
    public String test() {
        System.out.println("测试");
        return "hello";
    }
    @ApiOperation("entity中Map-》data测试")
    @GetMapping("/testR")
    public R testR(){
        System.out.println("new Date()"+new Date());
        return R.ok().data("message","hello").data("now", new Date());
    }

    @ApiOperation("ProductService 获取商品列表")
    @GetMapping("/list")
    public R list(){
        System.out.println("ProductService 获取商品列表");
        List<Product> list = productService.list();

        return R.ok().data("productList",list).data("now", new Date());
    }
}
