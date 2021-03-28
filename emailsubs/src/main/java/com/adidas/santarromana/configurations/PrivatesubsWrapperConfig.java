package com.adidas.santarromana.configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Configuration
public class PrivatesubsWrapperConfig {

    @Value("${privatesubs.user:default}")
    String user;

    @Value("${privatesubs.pass:default}")
    String pass;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(user, pass));
        return restTemplate;
    }
}
