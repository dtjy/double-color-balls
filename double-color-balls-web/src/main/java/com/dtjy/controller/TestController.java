package com.dtjy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dtjy.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangyao
 * @Date 2019/9/17 10:26
 **/
@Controller
@RequestMapping("test")
public class TestController {

    @Reference(version = "1.0.0",timeout = 3000)
    TestService testService;

    @Reference(version = "2.0.0",timeout = 3000)
    TestService demoService;

    @RequestMapping("t1")
    @ResponseBody
    public String test1(){
        return testService.test();
    }

    @RequestMapping("t2")
    @ResponseBody
    public String test2(){
        return demoService.test1();
    }
}
