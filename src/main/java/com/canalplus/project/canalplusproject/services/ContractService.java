package com.canalplus.project.canalplusproject.services;

import com.canalplus.project.canalplusproject.models.Address;
import com.canalplus.project.canalplusproject.models.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractService {

              public Contract saveContract(Contract contract);
              public List<Contract> getAllContractBySubscriberId(Long SubscriberId);
              public Optional<Contract> findContractById(Long id);
              public void updateContract(Long subscriberId, Address address);


}
