package com.adidas.santarromana.exceptions;

public class SubscriptionException extends Exception {

    public SubscriptionException() {
        super();
    }

    public SubscriptionException(String message) {
        super(message);
    }

    public SubscriptionException(Exception e) {
        super(e);
    }
}
