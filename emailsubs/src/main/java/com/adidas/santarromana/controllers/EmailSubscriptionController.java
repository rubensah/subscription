package com.adidas.santarromana.controllers;

import com.adidas.santarromana.model.Subscription;
import com.adidas.santarromana.services.EmailSubscriptionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.adidas.santarromana.model.Constants.SEND_EMAIL_PATH;

@RestController
public class EmailSubscriptionController {

    @Autowired
    private EmailSubscriptionService emailSubscriptionService;

    @PostMapping(SEND_EMAIL_PATH)
    @ApiOperation(value = "Send email", notes = "Send an email to subscription email")
    public void sendMail(@ApiParam(name = "subscriptionData", value = "Subscription data in JSON", required = true)
                             @RequestBody Subscription subscription) {
        emailSubscriptionService.sendEmail(subscription);
    }

}
