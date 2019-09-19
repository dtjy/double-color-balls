package com.dtjy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dtjy.service.BallService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jiangyao
 * @Date 2019/9/18 15:18
 **/
@Service(version = "0.0.1",timeout = 3000)
public class BallServiceImpl implements BallService {
    @Override
    public List<String> anaylse(String balls,String blueMatch,Integer redMatchNum) {
        //取出所有数据
        List<String> all = new ArrayList<>();
        List<String> anayList = new ArrayList<>();
        String[] s;
        for (String one : all){
            int j=0;
            s = one.split(",");
                for (int i=0 ;i<s.length; i++){
                    if (s[i].indexOf(one)>=0){
                        j++;
                    }
                }
                if (j==redMatchNum){
                    anayList.add(one);
                }
        }
        return anayList;
    }
}
