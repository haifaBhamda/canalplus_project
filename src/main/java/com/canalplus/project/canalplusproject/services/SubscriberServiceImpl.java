package com.canalplus.project.canalplusproject.services;

import com.canalplus.project.canalplusproject.models.Subscriber;
import com.canalplus.project.canalplusproject.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SubscriberServiceImpl implements SubscriberService {
    @Autowired
    SubscriberRepository subscriberRepository;

    @Override
    public Subscriber saveSubscriber(Subscriber subscriber) {

        return subscriberRepository.save(subscriber);
    }

    @Override
    public Subscriber findSubscriberByFirstNameAndLastName(String firstName, String lastName) {
        return subscriberRepository.findSubscriberByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public Optional<Subscriber> findById(Long subscriberId) {
        return subscriberRepository.findById(subscriberId);
    }

    @Override
    public boolean existsById(Long subscriberId) {
        return subscriberRepository.existsById(subscriberId);
    }


    @Override
    public Optional<Subscriber> findSubscriberById(Long subscriberId) {
        return subscriberRepository.findById(subscriberId);
    }
}
