package com.adidas.santarromana.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Subscription {
    private Long subscriptionId;
    private String email;
    private String firstName;
    private String gender;
    private Date dateOfBirth;
    private boolean consent;
    private String newsletterId;
}
