package com.dtjy.service.mq;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author jiangyao
 * @Date 2019/9/20 16:33
 **/
@Component
public class KafkaListenerTest {

    @KafkaListener(topics = "test_topic")
    public void onMessage(String message){
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println(message);
    }
}
