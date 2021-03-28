package com.adidas.santarromana.services;

import com.adidas.santarromana.components.BasicMailSenderComponent;
import com.adidas.santarromana.model.Constants;
import com.adidas.santarromana.model.Subscription;
import com.adidas.santarromana.utils.RetrySendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailSubscriptionService {

    @Autowired
    BasicMailSenderComponent basicMailSenderComponent;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${privatesubs.url}")
    String url;

    public void sendEmail(Subscription subscription) {
        if(sendEmailWithAttemps(subscription)){
            putSubscriptionNotified(subscription);
        }
    }

    private boolean sendEmailWithAttemps(Subscription subscription) {
        RetrySendMail retry = new RetrySendMail();
        while (retry.hasToRetry()) {
            try {
                basicMailSenderComponent.sendSimpleMessage(subscription);
                retry.setDone(true);
            } catch (MailException ex) {
                retry.addNewAttempt();
            }
        }
        return retry.isDone();
    }

    private void putSubscriptionNotified(Subscription subscription) {
        restTemplate.put(url + Constants.UPDATE_NOTIFIED_PATH, subscription);
    }
}
