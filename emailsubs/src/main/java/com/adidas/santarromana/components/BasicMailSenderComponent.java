package com.adidas.santarromana.components;

import com.adidas.santarromana.utils.MailUtils;
import com.adidas.santarromana.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class BasicMailSenderComponent {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(Subscription subs) throws MailException {
        emailSender.send(MailUtils.buildSimpleMailMessage(subs));
    }
}
