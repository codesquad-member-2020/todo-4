package com.codesquad.server.presentation.controllers;

import com.codesquad.server.domain.entity.Card;
import com.codesquad.server.domain.entity.Columns;
import com.codesquad.server.domain.repository.CardRepository;
import com.codesquad.server.domain.repository.ColumnsRepository;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/columns/{columnId}/cards")
public class CardController {
    private final Logger logger = LoggerFactory.getLogger(CardController.class);

    @Autowired
    ColumnsRepository columnsRepository;

    @Autowired
    CardRepository cardRepository;

    /**
     * Card을 생성한다.
     *
     * @RequestBody
     *{
     * 	"note": "순두부찌개는 맛있어",
     * }
     *
     * @return
     * Status Code를 반환(CREATED, 201)
     */
    @PostMapping("")
    public JSONObject create(@PathVariable Long columnId, @RequestBody Map<String, String> bodyMap) {
        Columns columns = columnsRepository.findById(columnId).orElseThrow(NoSuchElementException::new);
        columns.addCard(bodyMap.get("note"));
        columnsRepository.save(columns);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("StatusCode", HttpStatus.CREATED.value());
        return jsonObject;
    }

    /**
     * 해당하는 Column의 전체 Card 목록 반환
     *
     * @return
     * Column 객체가 json 형태로 반환
     */
    @GetMapping("")
    public List<Card> list(@PathVariable Long columnId) {
        Columns columns = columnsRepository.findById(columnId).orElseThrow(NoSuchElementException::new);
        return columns.getCards();
    }

    /**
     * Card 이름 수정
     *
     * @RequestBody
     *{
     * 	"afterNote": "노맛존맛"
     * }
     *
     * @return
     * Status Code를 반환(NO_CONTENT, 204)
     */
    @PutMapping("/{cardId}")
    public JSONObject update(@PathVariable Long cardId, @RequestBody HashMap<String, String> bodyMap) {
        Card card = cardRepository.findById(cardId).orElseThrow(NoSuchElementException::new);
        card.setNote(bodyMap.get("afterNote"));
        cardRepository.save(card);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("StatusCode", HttpStatus.NO_CONTENT.value());
        return jsonObject;
    }

    /**
     * Card 삭제
     *
     * @return
     * Status Code를 반환(NO_CONTENT, 204)
     */
    @DeleteMapping("/{cardId}")
    public JSONObject delete(@PathVariable Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(NoSuchElementException::new);
        cardRepository.delete(card);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("StatusCode", HttpStatus.NO_CONTENT.value());
        return jsonObject;
    }
}