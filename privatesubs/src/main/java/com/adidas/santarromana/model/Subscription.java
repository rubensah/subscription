package com.adidas.santarromana.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscription_id")
    private Long subscriptionId;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "consent", nullable = false)
    private boolean consent;

    @Column(name = "newsletter_id", nullable = false)
    private String newsletterId;

    @Column(name = "notified", nullable = false)
    private boolean notified;

    public boolean isValid(){
        return StringUtils.hasLength(email) && dateOfBirth != null && StringUtils.hasLength(newsletterId);
    }
}
