package com.canalplus.project.canalplusproject;


import com.canalplus.project.canalplusproject.models.Address;
import com.canalplus.project.canalplusproject.models.Subscriber;
import com.canalplus.project.canalplusproject.repositories.SubscriberRepository;
import com.canalplus.project.canalplusproject.services.SubscriberServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ManageSubscriberTest {

    private static final Long ID_SUBSCRIBER =10L;

    private static final String LAST_NAME ="BEN HAMDA";

    private static final String FIRST_NAME ="HAIFA";

    private static final String Street_Address =     "14 rue du chateau boulogne billancourt";

    private static final String COUNTRY =     "France";

    private static final  String ZIP_CODE = "92100";



    @InjectMocks
    SubscriberServiceImpl subscriberServiceImpl;

    @Mock
    SubscriberRepository subscriberRepository;



    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  saveSubscriberTest(){
        Subscriber newSubscriber = new Subscriber();
        newSubscriber.setFirstName(FIRST_NAME);
        newSubscriber.setLastName(LAST_NAME);
        Address address = new Address();
        address.setStreetAddress(Street_Address);
        address.setCountry(COUNTRY);
        address.setZipCode(ZIP_CODE);
        newSubscriber.setAddressSubscriber(address);
        newSubscriber.setAddressSubscriber(newSubscriber.getAddressSubscriber());

        /* create new subscriber */
        Mockito.when(subscriberRepository.save(Mockito.any(Subscriber.class))).thenReturn(newSubscriber);
        Subscriber subscriberCreated = subscriberServiceImpl.saveSubscriber(newSubscriber);
        /*verify the information of subscriber  */
        Assert.assertNotNull(subscriberCreated);
        Assert.assertEquals(subscriberCreated.getLastName(),newSubscriber.getLastName());
        Assert.assertEquals(subscriberCreated.getFirstName(),newSubscriber.getFirstName());
        Assert.assertEquals(subscriberCreated.getAddressSubscriber().getStreetAddress(),
                newSubscriber.getAddressSubscriber().getStreetAddress());
        Assert.assertEquals(subscriberCreated.getAddressSubscriber().getCountry(),
                newSubscriber.getAddressSubscriber().getCountry());
        Assert.assertEquals(subscriberCreated.getAddressSubscriber().getZipCode(),
                newSubscriber.getAddressSubscriber().getZipCode());
    }
    @Test
    public void  existSubscriberById(){
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(FIRST_NAME);
        subscriber.setLastName(LAST_NAME);
        subscriber.setIdSubscriber(ID_SUBSCRIBER);
        /* create new subscriber */
        Mockito.when(subscriberRepository.existsById(Mockito.any(Long.class))).thenReturn(true);
        boolean subscriberResult = subscriberServiceImpl.existsById(ID_SUBSCRIBER);
        /*verify subscriber is exist */
        Assert.assertTrue(subscriberResult);
    }

    @Test
    public void  findSubscriberByIdTest(){
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(FIRST_NAME);
        subscriber.setLastName(LAST_NAME);
        subscriber.setIdSubscriber(ID_SUBSCRIBER);
        /* create new subscriber */
        Mockito.when(subscriberRepository.findById(Mockito.any(Long.class))).thenReturn(java.util.Optional.of(subscriber));
        Optional< Subscriber>  subscriberResult=subscriberServiceImpl.findById(ID_SUBSCRIBER);
        /*verify subscriber is created */
        Assert.assertNotNull(subscriberResult);
        Assert.assertEquals(subscriberResult.map(Subscriber::getIdSubscriber).orElse(null),subscriber.getIdSubscriber());
        Assert.assertEquals(subscriberResult.map(Subscriber::getFirstName).orElse(null),subscriber.getFirstName());
        Assert.assertEquals(subscriberResult.map(Subscriber::getLastName).orElse(null),subscriber.getLastName());

    }


    @Test
    public void  findSubscriberByFirstNameAndLastName() {
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(FIRST_NAME);
        subscriber.setLastName(LAST_NAME);
        subscriber.setIdSubscriber(ID_SUBSCRIBER);
        /* create new subscriber */
        Mockito.when(subscriberRepository.findSubscriberByFirstNameAndLastName(FIRST_NAME, LAST_NAME)).thenReturn((subscriber));
        Subscriber subscriberCreated = subscriberServiceImpl.findSubscriberByFirstNameAndLastName(subscriber.getFirstName(), subscriber.getLastName());
        Assert.assertEquals(subscriberCreated.getIdSubscriber(), subscriber.getIdSubscriber());

    }

    }
