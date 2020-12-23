package com.canalplus.project.canalplusproject.repositories;
import com.canalplus.project.canalplusproject.models.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long> {
    public List<Contract> findContractBySubscriberIdSubscriber(Long subscriberId);

}