package com.project.thirdpartyserver;

import io.github.cdimascio.dotenv.Dotenv;
import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableDiscoveryClient 
@SpringBootApplication
public class ThirdPartyServerApplication {

    public static void main(String[] args) {

        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(ThirdPartyServerApplication.class, args);
    }

}
