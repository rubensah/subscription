package com.adidas.santarromana.controllers;

import com.adidas.santarromana.model.Subscription;
import com.adidas.santarromana.services.SubscriptionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import static com.adidas.santarromana.model.Constants.CANCEL_PATH;
import static com.adidas.santarromana.model.Constants.CREATE_PATH;
import static com.adidas.santarromana.model.Constants.GET_SUBSCRIPTION_PATH;
import static com.adidas.santarromana.model.Constants.LIST_ALL_SUBSCRIPTIONS_PATH;


@RequiredArgsConstructor
@RestController
public class PublicSubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping(CREATE_PATH)
    @ApiOperation(value = "Create a new subscription", notes = "This operation creates a new subscription with the given data")
    public ResponseEntity<Long> createSubscription(
            @ApiParam(name = "subscriptionData", value = "Subscription data", required = true)
            @RequestBody Subscription subscription) {
        try {
            return ResponseEntity.ok(subscriptionService.createSubscription(subscription));
        } catch (HttpClientErrorException exc) {
            return ResponseEntity.status(HttpStatus.valueOf(exc.getRawStatusCode())).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping(CANCEL_PATH)
    @ApiOperation(value = "Cancel existing subscription", notes = "This operation cancels the subscription with the given ID")
    public ResponseEntity<Subscription> cancelSubscription(
            @ApiParam(name = "subscriptionId", value = "The identifier of a concrete subscription", required = true)
            @PathVariable("subscriptionId") String subscriptionId) {
        try {
            return ResponseEntity.ok(subscriptionService.cancelSubscription(subscriptionId));
        } catch (HttpClientErrorException exc) {
            return ResponseEntity.status(HttpStatus.valueOf(exc.getRawStatusCode())).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(GET_SUBSCRIPTION_PATH)
    @ApiOperation(value = "Get details of a subscription", notes = "This operation gets the detail for the subscription with the given ID")
    public ResponseEntity<Subscription> getSubscription(
            @ApiParam(name = "subscriptionID", value = "The identifier of a concrete subscription", required = true)
            @PathVariable("subscriptionId") String subscriptionId) {
        try {
            return ResponseEntity.ok(subscriptionService.getSubscription(subscriptionId));
        } catch (HttpClientErrorException exc) {
            return ResponseEntity.status(HttpStatus.valueOf(exc.getRawStatusCode())).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(LIST_ALL_SUBSCRIPTIONS_PATH)
    @ApiOperation(value = "Get all subscriptions", notes = "This operation returns all the subscriptions")
    public ResponseEntity<Iterable<Subscription>> getAllSubscriptions() {
        try {
            return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
        } catch (HttpClientErrorException exc) {
            return ResponseEntity.status(HttpStatus.valueOf(exc.getRawStatusCode())).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
