package com.pblgllgs.sb3mcsvccompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Sb3McsvcCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb3McsvcCompanyApplication.class, args);
    }

}
