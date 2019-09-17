package com.dtjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * @Author jiangyao
 * @Date 2019/9/17 10:03
 **/
@SpringBootApplication
public class DoubleColorBallsWebApplication {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(DoubleColorBallsWebApplication.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }
}
