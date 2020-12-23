package com.canalplus.project.canalplusproject.controllers;

import com.canalplus.project.canalplusproject.models.Contract;
import com.canalplus.project.canalplusproject.models.History;
import com.canalplus.project.canalplusproject.services.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryController {

    @Autowired
    HistoryServiceImpl historyServiceImpl;

    @GetMapping("/history/{subscriberId}/getHistory")
    public List<History> findHistories(@PathVariable(value = "subscriberId") Long subscriberId) {
        return historyServiceImpl.findHistories(subscriberId);
    }
}
