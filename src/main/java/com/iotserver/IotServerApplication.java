package com.iotserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class IotServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotServerApplication.class, args);
    }

}
