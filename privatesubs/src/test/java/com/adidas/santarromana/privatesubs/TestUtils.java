package com.adidas.santarromana.privatesubs;

import com.adidas.santarromana.model.Subscription;

import java.util.Date;

public class TestUtils {

    public static Subscription getDummySubscription() {
        Subscription dummy = new Subscription();
        dummy.setFirstName("Test");
        dummy.setConsent(true);
        dummy.setGender("no");
        dummy.setDateOfBirth(new Date());
        dummy.setEmail("test@prueba.com");
        dummy.setNewsletterId("TestID");
        dummy.setNotified(false);
        return dummy;
    }
}
