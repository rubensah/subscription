package com.adidas.santarromana.privatesubs;

import com.adidas.santarromana.datastore.SubscriptionDAO;
import com.adidas.santarromana.model.Subscription;
import com.adidas.santarromana.services.SubscriptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PrivatesubsApplicationTests {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    @Test
    public void createSubscriptionTest() {
        Subscription subscriptionTest = subscriptionDAO.save(TestUtils.getDummySubscription());
        Assertions.assertNotNull(subscriptionTest);
        Assertions.assertNotNull(subscriptionTest.getSubscriptionId());
    }

    @Test
    public void getAllEmployeesTest() {
        Iterable<Subscription> subscriptionTestList = subscriptionService.getAllSubscriptions();
        Assertions.assertNotNull(subscriptionTestList);
    }

    @Test
    public void getDetailTest() {
        Iterable<Subscription> subscriptionTestList = subscriptionService.getAllSubscriptions();
        Assumptions.assumeTrue(subscriptionTestList.iterator().hasNext());
        Assertions.assertNotNull(subscriptionService.getSubscription(subscriptionTestList.iterator().next().getSubscriptionId()));
    }

    @Test
    public void putNotifiedTest() {
        Iterable<Subscription> subscriptionTestList = subscriptionService.getAllSubscriptions();
        Assumptions.assumeTrue(subscriptionTestList.iterator().hasNext());
        Assertions.assertTrue(subscriptionService.putNotified(subscriptionTestList.iterator().next()).isNotified());
    }
}
