package com.canalplus.project.canalplusproject.services;

import com.canalplus.project.canalplusproject.models.Subscriber;

import java.util.Optional;

public interface SubscriberService {

    public Subscriber saveSubscriber(Subscriber subscriber);
    public Optional<Subscriber> findSubscriberById(Long subscriberId);
    public Subscriber findSubscriberByFirstNameAndLastName(String firstName,String lastName);
    public Optional<Subscriber> findById(Long subscriberId);
    public boolean existsById(Long subscriberId);


}
