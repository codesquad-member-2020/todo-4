package com.codesquad.server.presentation.controllers;

import com.codesquad.server.domain.service.ColumnsService;
import com.codesquad.server.domain.value.RequestColumnsDTO;
import com.codesquad.server.domain.value.ResponseColumnsAndHistoriesDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/columns")
public class ColumnsController {

    private final ColumnsService columnsService;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("")
    public ResponseColumnsAndHistoriesDTO list() {
        return columnsService.list();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("")
    public LocalDateTime update(@RequestBody @Valid RequestColumnsDTO requestColumnsDTO) {
        return columnsService.update(requestColumnsDTO);
    }
}
