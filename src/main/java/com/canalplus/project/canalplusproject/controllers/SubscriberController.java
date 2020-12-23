package com.canalplus.project.canalplusproject.controllers;


import com.canalplus.project.canalplusproject.models.*;
import com.canalplus.project.canalplusproject.services.ContractServiceImpl;
import com.canalplus.project.canalplusproject.services.SubscriberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class SubscriberController {
    @Autowired
    SubscriberServiceImpl subscriberServiceImpl;
    @Autowired
    ContractServiceImpl contractServiceImpl;


    /**
     * Add new subscriber in H2 database.
     *
     * @return subscriber
     */

    @PostMapping("/createSubscriber")
    public ResponseEntity<Subscriber> createNewSubscriber(@RequestBody Subscriber subscriber) {
        Subscriber existingSubscriber =
                subscriberServiceImpl.findSubscriberByFirstNameAndLastName(subscriber.getFirstName(), subscriber.getLastName());
        if (existingSubscriber != null) {
            return new ResponseEntity<Subscriber>(HttpStatus.CONFLICT);
        }
        subscriberServiceImpl.saveSubscriber(subscriber);
        return new ResponseEntity<Subscriber>(HttpStatus.CREATED);
    }




    /**
     * update address of subscriber in subscriber information and all contracts
     */

    @PutMapping("/subscribers/{subscriberId}")
    public Optional<Subscriber> updateSubscriberAddress(@PathVariable Long subscriberId,
                                                        @RequestBody Address addressContract) {

        return subscriberServiceImpl.findById(subscriberId).map(subscriber -> {

            /* Update subscriber address */
            subscriber.setAddressSubscriber(addressContract);

            /* Update contracts address */
            contractServiceImpl.updateContract(subscriberId, addressContract);
            return subscriberServiceImpl.saveSubscriber(subscriber);
        });

    }


}
