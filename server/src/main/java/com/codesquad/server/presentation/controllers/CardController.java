package com.codesquad.server.presentation.controllers;

import com.codesquad.server.domain.service.CardService;
import com.codesquad.server.domain.value.RequestCardDTO;
import com.codesquad.server.domain.value.RequestLocationDTO;
import com.codesquad.server.domain.value.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/columns/{columnId}/cards")
public class CardController {

    private final CardService cardService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("")
    public ResponseDTO create(@PathVariable Long columnId, @RequestBody @Valid RequestCardDTO requestCardDTO) {
        return cardService.save(requestCardDTO, columnId);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("")
    public LocalDateTime update(@RequestBody @Valid RequestCardDTO requestCardDTO) {
        return cardService.update(requestCardDTO);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/move")
    public LocalDateTime move(@RequestBody @Valid RequestLocationDTO requestLocationDTO) {
        return cardService.move(requestLocationDTO);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("")
    public LocalDateTime delete(@RequestBody @Valid RequestCardDTO requestCardDTO) {
        return cardService.delete(requestCardDTO);
    }
}
