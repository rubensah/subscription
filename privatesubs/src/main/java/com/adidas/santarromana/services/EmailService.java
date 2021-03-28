package com.adidas.santarromana.services;

import com.adidas.santarromana.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${emailsubs.url}")
    String url;

    public void sendEmail(Subscription subscription) {
        restTemplate.postForObject(url + "/sendMail", subscription, Subscription.class);
    }
}
