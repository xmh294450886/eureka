package edu.neu.springcloud.configeureka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ConfigEureka2Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEureka2Application.class, args);
    }

}
