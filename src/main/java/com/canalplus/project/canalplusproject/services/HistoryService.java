package com.canalplus.project.canalplusproject.services;


import com.canalplus.project.canalplusproject.models.History;
import com.canalplus.project.canalplusproject.models.Subscriber;

import java.util.List;

public interface HistoryService {

    History saveHistory(History history);
    List<History> findHistories(Long SubscriberId);
}
