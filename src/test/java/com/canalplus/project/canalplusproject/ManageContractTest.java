package com.canalplus.project.canalplusproject;


import com.canalplus.project.canalplusproject.models.Address;
import com.canalplus.project.canalplusproject.models.Contract;
import com.canalplus.project.canalplusproject.models.Subscriber;
import com.canalplus.project.canalplusproject.repositories.ContractRepository;
import com.canalplus.project.canalplusproject.services.ContractServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class ManageContractTest {


    private static final Long ID_CONTRACT = 12L;

    private static final Long ID_SUBSCRIBER = 10L;

    private static final String LAST_NAME = "BEN HAMDA";

    private static final String FIRST_NAME = "HAIFA";

    private static final String STREET_ADDRESS_CONTRACT = "14 rue du chateau boulogne billancourt";

    private static final String COUNTRY_CONTRACT = "France";

    private static final String ZIP_CODE_CONTRACT = "92100";

    private static final String STREET_ADDRESS_SBSCRIBER = "5bis Place Jean Macé  Lyon";

    private static final String COUNTRY_SBSCRIBER = "France";

    private static final String ZIP_CODE_SUBSCRIBER = "69007";

    private static final String STREET_ADDRESS_CONTRACT_UPDATE = "14 rue des peupliers paris 15";

    private static final String COUNTRY_CONTRACT_UPDATE = "France";

    private static final String ZIP_CODE_CONTRACT_UPDATE = "75015";

    @InjectMocks
    ContractServiceImpl contractServiceImpl;

    @Mock
    ContractRepository contractRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createContractTest() {
        Contract newContract = new Contract();
        newContract.setIdContract(ID_CONTRACT);
        Address address1 = new Address();
        address1.setStreetAddress(STREET_ADDRESS_CONTRACT);
        address1.setCountry(COUNTRY_CONTRACT);
        address1.setZipCode(ZIP_CODE_CONTRACT);
        newContract.setAddressContract(address1);
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(FIRST_NAME);
        subscriber.setLastName(LAST_NAME);
        subscriber.setIdSubscriber(ID_SUBSCRIBER);
        Address address = new Address();
        address.setStreetAddress(STREET_ADDRESS_SBSCRIBER);
        address.setCountry(COUNTRY_SBSCRIBER);
        address.setZipCode(ZIP_CODE_SUBSCRIBER);
        subscriber.setAddressSubscriber(address);
        newContract.setSubscriber(subscriber);


        /* create new contract */
        Mockito.when(contractRepository.save(Mockito.any(Contract.class))).thenReturn(newContract);
        Contract contractResult = contractServiceImpl.saveContract(newContract);
        Assert.assertEquals(contractResult.getSubscriber().getIdSubscriber(), subscriber.getIdSubscriber());
        Assert.assertEquals(contractResult.getSubscriber().getFirstName(), subscriber.getFirstName());
        Assert.assertEquals(contractResult.getSubscriber().getLastName(), subscriber.getLastName());
        Assert.assertEquals(contractResult.getSubscriber().getAddressSubscriber().getZipCode(), subscriber.getAddressSubscriber().getZipCode());

    }

    @Test
    public void findContractBySubscriberIdTest() {
        /*create new contract*/
        Contract newContract = new Contract();
        newContract.setIdContract(ID_CONTRACT);
        Address address1 = new Address();
        address1.setStreetAddress(STREET_ADDRESS_CONTRACT);
        address1.setCountry(COUNTRY_CONTRACT);
        address1.setZipCode(ZIP_CODE_CONTRACT);
        newContract.setAddressContract(address1);
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(FIRST_NAME);
        subscriber.setLastName(LAST_NAME);
        subscriber.setIdSubscriber(ID_SUBSCRIBER);
        Address address = new Address();
        address.setStreetAddress(STREET_ADDRESS_SBSCRIBER);
        address.setCountry(COUNTRY_SBSCRIBER);
        address.setZipCode(ZIP_CODE_SUBSCRIBER);
        subscriber.setAddressSubscriber(address);
        newContract.setSubscriber(subscriber);

        Mockito.when(contractRepository.findContractBySubscriberIdSubscriber(Mockito.any(Long.class))).thenReturn(Collections.singletonList(newContract));
        List<Contract> contractResult = contractServiceImpl.getAllContractBySubscriberId(ID_SUBSCRIBER);
        Assert.assertNotNull(contractResult);
        Assert.assertEquals(contractResult.get(0).getSubscriber().getIdSubscriber(), ID_SUBSCRIBER);
    }
}
