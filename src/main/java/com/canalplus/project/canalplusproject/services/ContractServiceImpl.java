package com.canalplus.project.canalplusproject.services;
import com.canalplus.project.canalplusproject.models.Address;
import com.canalplus.project.canalplusproject.models.Contract;
import com.canalplus.project.canalplusproject.models.History;
import com.canalplus.project.canalplusproject.models.ModificationType;
import com.canalplus.project.canalplusproject.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private HistoryServiceImpl historyServiceImpl;

    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> getAllContractBySubscriberId(Long subscriberId) {
        return contractRepository.findContractBySubscriberIdSubscriber(subscriberId);
    }

    @Override
    public Optional<Contract> findContractById(Long id) {
        return contractRepository.findById(id);
    }

    @Override
    public void updateContract(Long subscriberId, Address address) {

        if(!address.getCountry().equals("France"))
        {
            Contract contract = this.getAllContractBySubscriberId(subscriberId).get(0);

            /* Get old address before modification */
            String oldContractAddress = contract.getAddressContract().toString();

            /* Update first element international subscriber */
            contract.setAddressContract(address);

            /* Save contracts history */
            historyServiceImpl.saveHistory(new History(subscriberId, contract.getIdContract(), ModificationType.Address.name(),
                    LocalDateTime.now(), oldContractAddress, contract.getAddressContract().toString()));
        }
        else {
            this.getAllContractBySubscriberId(subscriberId).forEach(contracts -> {

                /* Get old address before modification */
                String oldContractAddress = contracts.getAddressContract().toString();

                /* Update contract address */
                contracts.setAddressContract(address);
                this.saveContract(contracts);

                /* Save contracts history */
                historyServiceImpl.saveHistory(new History(subscriberId, contracts.getIdContract(), ModificationType.Address.name(),
                        LocalDateTime.now(), oldContractAddress, address.toString()));
            });
        }
    }

}
