package com.dtjy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dtjy.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author jiangyao
 * @Date 2019/9/17 10:26
 **/
@Controller
@RequestMapping("test")
public class TestController {

    @Reference(version = "1.0.0",timeout = 300)
    TestService testService;
}
