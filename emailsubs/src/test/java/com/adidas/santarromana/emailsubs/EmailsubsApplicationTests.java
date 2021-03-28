package com.adidas.santarromana.emailsubs;

import com.adidas.santarromana.components.BasicMailSenderComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSendException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
class EmailsubsApplicationTests {

    @Autowired
    BasicMailSenderComponent basicMailSenderComponent;

    @Value("${spring.mail.host}")
    String urlconf;

    @Value("${spring.mail.port}")
    String portconf;

    private final int MAILHOG_RESPONSE_STATUS = -1;

    public boolean checkConnection(){
        try {
            URL url = new URL("http://" + urlconf + ":" + portconf);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            int responseCode = huc.getResponseCode();
            return HttpURLConnection.HTTP_OK == responseCode || responseCode == MAILHOG_RESPONSE_STATUS;
        } catch (Exception e) {
            return false;
        }
    }

    @Test()
    void sendEmailTest() {
        Assumptions.assumeTrue(checkConnection());
        Assertions.assertDoesNotThrow(() -> basicMailSenderComponent.sendSimpleMessage(TestUtils.getDummySubscription()));
    }

}
