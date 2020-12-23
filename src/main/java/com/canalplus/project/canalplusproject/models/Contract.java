package com.canalplus.project.canalplusproject.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;


@Entity
@Table(name = "TBL_CONTRACT")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContract;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    @Embedded
    @JsonProperty("addressContract")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Address addressContract;

    public Contract() {
    }

    public Contract(Subscriber subscriber, Address addressContract) {
        this.subscriber = subscriber;
        this.addressContract = addressContract;
    }

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Address getAddressContract() {
        return addressContract;
    }

    public void setAddressContract(Address addressContract) {
        this.addressContract = addressContract;
    }
}
