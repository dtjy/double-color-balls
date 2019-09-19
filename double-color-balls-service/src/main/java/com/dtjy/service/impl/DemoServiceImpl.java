package com.dtjy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dtjy.service.TestService;

/**
 * @Author jiangyao
 * @Date 2019/9/18 10:47
 **/
@Service(version = "2.0.0",timeout = 3000)
public class DemoServiceImpl implements TestService {
    @Override
    public String test() {
        return "test3";
    }

    @Override
    public String test1() {
        return "test2";
    }
}
