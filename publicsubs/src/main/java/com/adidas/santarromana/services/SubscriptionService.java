package com.adidas.santarromana.services;

import com.adidas.santarromana.model.Constants;
import com.adidas.santarromana.model.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SubscriptionService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${privatesubs.url}")
    String url;

    public long createSubscription(Subscription subscription) {
        return restTemplate.postForObject(url + Constants.CREATE_PATH, subscription, Subscription.class).getSubscriptionId();
    }

    public Subscription cancelSubscription(String subscriptionId) {
        return restTemplate.getForObject(url + Constants.CANCEL_PATH, Subscription.class, createMapParams(subscriptionId));
    }

    public Subscription getSubscription(String subscriptionId) {
        return restTemplate.getForObject(url + Constants.GET_SUBSCRIPTION_PATH, Subscription.class, createMapParams(subscriptionId));
    }

    public Iterable<Subscription> getAllSubscriptions() {
        return restTemplate.exchange(url + Constants.LIST_ALL_SUBSCRIPTIONS_PATH, HttpMethod.GET, null, Iterable.class).getBody();
    }

    private Map<String, String> createMapParams(String subscriptionId) {
        Map<String, String> params = new HashMap<>();
        params.put("subscriptionId", subscriptionId);
        return params;
    }
}
