package com.dtjy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.jms.annotation.EnableJms;

/**
 * @Author jiangyao
 * @Date 2019/9/17 10:03
 **/
@SpringBootApplication
@EnableJms
public class DoubleColorBallsServiceApplication {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(DoubleColorBallsServiceApplication.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }
}
