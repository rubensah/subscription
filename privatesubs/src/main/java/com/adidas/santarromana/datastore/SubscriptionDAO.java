package com.adidas.santarromana.datastore;

import com.adidas.santarromana.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDAO extends CrudRepository<Subscription, Long> {

}
