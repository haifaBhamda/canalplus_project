package com.canalplus.project.canalplusproject.services;

import com.canalplus.project.canalplusproject.models.History;
import com.canalplus.project.canalplusproject.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryRepository historyRepository;
    @Override
    public History saveHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public List<History> findHistories(Long subscriberId) {
        return historyRepository.findBySubscriberId(subscriberId);
    }
}
