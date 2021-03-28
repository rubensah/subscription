package com.adidas.santarromana.publicsubs;

import com.adidas.santarromana.services.SubscriptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
class PublicsubsApplicationTests {

    @Value("${privatesubs.url}")
    String urlconf;

    @Autowired
    SubscriptionService subscriptionService;

    public boolean checkConnection(){
        try {
            URL url = new URL(urlconf);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            int responseCode = huc.getResponseCode();
            return HttpURLConnection.HTTP_OK == responseCode;
        } catch (IOException e) {
            return false;
        }
    }

    @Test()
    void getAllSubscriptionsTest() {
        Assumptions.assumeTrue(checkConnection());
        Assertions.assertDoesNotThrow(() -> subscriptionService.getAllSubscriptions());
        Assertions.assertNotNull(subscriptionService.getAllSubscriptions());
    }
}
