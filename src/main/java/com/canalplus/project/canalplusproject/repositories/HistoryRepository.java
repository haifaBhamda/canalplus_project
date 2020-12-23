package com.canalplus.project.canalplusproject.repositories;

import com.canalplus.project.canalplusproject.models.History;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoryRepository extends CrudRepository<History,Long> {
    public List<History> findBySubscriberId(Long subscriberId);

}
