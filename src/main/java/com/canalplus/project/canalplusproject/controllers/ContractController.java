package com.canalplus.project.canalplusproject.controllers;

import com.canalplus.project.canalplusproject.exception.ResourceNotFoundException;
import com.canalplus.project.canalplusproject.models.Contract;
import com.canalplus.project.canalplusproject.models.History;
import com.canalplus.project.canalplusproject.models.ModificationType;
import com.canalplus.project.canalplusproject.services.ContractServiceImpl;
import com.canalplus.project.canalplusproject.services.HistoryServiceImpl;
import com.canalplus.project.canalplusproject.services.SubscriberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ContractController {
    @Autowired
    private ContractServiceImpl contractServiceImpl;
    @Autowired
    private SubscriberServiceImpl subscriberServiceImpl;
    @Autowired
    private HistoryServiceImpl historyServiceImpl;


    /**
     * Add new create contract to subscriber in H2 database.
     */


    @PostMapping("/subscribers/{subscriberId}/createcontract")
    public Contract createContract(@PathVariable(value = "subscriberId") Long subscriberId, @RequestBody Contract contract) {
        return subscriberServiceImpl.findById(subscriberId).map(subscriber -> {
            contract.setSubscriber(subscriber);
            contractServiceImpl.saveContract(contract);
            historyServiceImpl.saveHistory(new History(subscriberId, contract.getIdContract(), ModificationType.creation.name(), LocalDateTime.now(), null,null));
            return contract;
        }).orElseThrow(() -> new ResourceNotFoundException("subscribeId" + subscriberId + "not found"));
    }


    /**
     * Get the information of subscriber'contract in H2 database.
     */


    @GetMapping("/subscribers/{subscriberId}/getAllContracts")
    public List<Contract> getAllContractsBySubscriberId(@PathVariable(value = "subscriberId") Long subscriberId) {
        return contractServiceImpl.getAllContractBySubscriberId(subscriberId);
    }


}
