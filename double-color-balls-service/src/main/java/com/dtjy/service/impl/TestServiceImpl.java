package com.dtjy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dtjy.service.TestService;

/**
 * @Author jiangyao
 * @Date 2019/9/17 11:45
 **/
@Service(version = "1.0.0",timeout = 3000)
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "dubbo success";
    }
}
