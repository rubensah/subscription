package com.adidas.santarromana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class EmailsubsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailsubsApplication.class, args);
    }

}
