package com.dtjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangyao
 * @Date 2019/9/18 13:46
 **/
@Controller
@RequestMapping("ball")
public class BallController {

    @RequestMapping("query")
    @ResponseBody
    public Object anaylse(){

        return null;
    }
}
