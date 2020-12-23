package com.canalplus.project.canalplusproject.repositories;

import com.canalplus.project.canalplusproject.models.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber,Long> {
    public Subscriber  findSubscriberByFirstNameAndLastName(String firstName,String lastName);
}
