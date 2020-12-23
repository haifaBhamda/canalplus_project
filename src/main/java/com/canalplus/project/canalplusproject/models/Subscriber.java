package com.canalplus.project.canalplusproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
@Table(name = "TBL_SUBSCRIBER")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubscriber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Embedded
    @JsonProperty("addressSubscriber")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Address addressSubscriber;

    public Subscriber() {

    }

    public Subscriber(String firstName, String lastName, Address addressSubscriber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressSubscriber = addressSubscriber;
    }

    public Long getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(Long idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddressSubscriber() {
        return addressSubscriber;
    }

    public void setAddressSubscriber(Address addressSubscriber) {
        this.addressSubscriber = addressSubscriber;
    }
}