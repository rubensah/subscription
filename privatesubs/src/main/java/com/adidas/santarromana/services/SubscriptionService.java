package com.adidas.santarromana.services;

import com.adidas.santarromana.datastore.SubscriptionDAO;
import com.adidas.santarromana.exceptions.SubscriptionException;
import com.adidas.santarromana.model.Subscription;
import com.adidas.santarromana.utils.SubscriptionDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    @Autowired
    private EmailService emailService;

    public Subscription createSubscription(Subscription subscription) throws SubscriptionException, IllegalArgumentException{
        if (!subscription.isValid()) {
            throw new SubscriptionException("Subscription data is not valid");
        }
        if (!SubscriptionDataValidator.isValidEmail(subscription.getEmail())) {
            throw new SubscriptionException("Invalid email");
        }
        Subscription subscriptionFromDB = subscriptionDAO.save(subscription);
        CompletableFuture.runAsync(() -> {
            emailService.sendEmail(subscriptionFromDB);
        });
        return subscriptionFromDB;
    }

    public void cancelSubscription(long subscriptionId) throws IllegalArgumentException{
        subscriptionDAO.deleteById(subscriptionId);
    }

    public Optional<Subscription> getSubscription(long subscriptionId) throws IllegalArgumentException {
        return subscriptionDAO.findById(subscriptionId);
    }

    public Iterable<Subscription> getAllSubscriptions() {
        return subscriptionDAO.findAll();
    }

    public Subscription putNotified(Subscription subscription) throws IllegalArgumentException{
        Subscription fromDB = subscriptionDAO.findById(subscription.getSubscriptionId()).get();
        if (fromDB.isNotified()) {
            return fromDB;
        } else {
            fromDB.setNotified(true);
            return subscriptionDAO.save(fromDB);
        }
    }
}
