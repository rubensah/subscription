package com.adidas.santarromana.emailsubs;

import com.adidas.santarromana.model.Subscription;

public class TestUtils {

    public static Subscription getDummySubscription(){
        Subscription dummy = new Subscription();
        dummy.setEmail("mail@prueba.com");
        dummy.setFirstName("Dummy Test");;
        dummy.setNewsletterId("Newsletter Dummy Test");
        return dummy;
    }
}
