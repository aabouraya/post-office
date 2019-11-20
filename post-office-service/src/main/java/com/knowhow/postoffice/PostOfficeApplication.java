package com.knowhow.postoffice;

import com.knowhow.postoffice.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableBinding(Sink.class)
@EnableConfigurationProperties({AppProperties.class})
public class PostOfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostOfficeApplication.class, args);
    }

}
