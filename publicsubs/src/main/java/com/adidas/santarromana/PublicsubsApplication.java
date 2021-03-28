package com.adidas.santarromana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableCaching
@EnableScheduling
@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.adidas")
public class PublicsubsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicsubsApplication.class, args);
    }

}
