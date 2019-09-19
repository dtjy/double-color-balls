package com.dtjy.service.mq;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author jiangyao
 * @Date 2019/9/19 10:36
 **/
@Component
@Slf4j
public class DoubleColorBallMq {

    private static final String DCB_PREFIX = "DCB";

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @JmsListener(destination = "dcb-last-data")
    public void lastData(String msg){
        JSONObject jsonObject = JSONObject.parseObject(msg);
        JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("data"));
        Map<String,Object> map = (Map<String,Object>)jsonArray.get(0);
        //判断数据是否已经存在
        if (redisTemplate.opsForHash().hasKey(DCB_PREFIX,map.get("expect").toString())){
            log.info("{}数据已经存在",map.get("expect").toString());
        }else {
            redisTemplate.opsForHash().put(DCB_PREFIX,map.get("expect"),map);
        }
        //模拟复杂数据处理 延时1s
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            log.error("线程异常",e);
        }
        //不能有返回值
//        return "";
    }

    @JmsListener(destination = "dcb-history-data")
    public void historyData(String msg){

        Map<String,Object> treeMap = (Map<String,Object>)JSONObject.parse(msg);
        log.info("大小：{}",treeMap.size());
        redisTemplate.opsForHash().putAll(DCB_PREFIX,treeMap);

        //存关系型数据库 todo

        //模拟复杂数据处理 延时3s
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("线程异常",e);
        }
    }
}
