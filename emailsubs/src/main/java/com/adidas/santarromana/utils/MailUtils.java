package com.adidas.santarromana.utils;

import com.adidas.santarromana.model.Subscription;
import org.springframework.mail.SimpleMailMessage;

public class MailUtils {

    public final static String DEFAULT_EMAIL_FROM = "noreply@subscription.com";

    private final static String EMAIL_SUBJECT = "Welcome to Adidas Subscription ";
    private final static String EMAIL_BODY_HEADER = "Congratulations";
    private final static String EMAIL_BODY_TEXT = "You have been subscribed to Adidas Newsletter";
    private final static String EMAIL_BODY_FOOTER = "Enjoy it!";
    private final static String BLANK = " ";

    public static SimpleMailMessage buildSimpleMailMessage(Subscription subs) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(DEFAULT_EMAIL_FROM);
        message.setTo(subs.getEmail());
        message.setSubject(buildSubject(subs));
        message.setText(buildBody(subs));
        return  message;
    }

    private static String buildSubject(Subscription subs){
        return EMAIL_SUBJECT + subs.getFirstName();
    }
    private static String buildBody(Subscription subs){
        StringBuilder sb = new StringBuilder();
        return sb.append(EMAIL_BODY_HEADER).append(BLANK).append(subs.getFirstName())
                .append(System.lineSeparator()).append(EMAIL_BODY_TEXT).append(BLANK)
                .append(subs.getNewsletterId()).append(System.lineSeparator()).append(EMAIL_BODY_FOOTER)
                .append(System.lineSeparator()).toString();
    }
}
