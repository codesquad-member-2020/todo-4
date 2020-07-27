package com.codesquad.server.presentation.controllers;

import com.codesquad.server.domain.entity.History;
import com.codesquad.server.domain.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryRepository historyRepository;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/histories")
    public Iterable<History> list() {
        return historyRepository.findAll();
    }
}
