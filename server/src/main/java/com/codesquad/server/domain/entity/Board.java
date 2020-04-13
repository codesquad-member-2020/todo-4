package com.codesquad.server.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Board {

    @Id
    private Long id;
    private LocalDateTime createdTime;
    private List<Columns> columns = new ArrayList<>();
    private List<History> histories = new ArrayList<>();

    public void addHistory(Long id, String nickname, String action, String actingColumn,
                           String movedColumn, LocalDateTime changedTime, String contents) {
        histories.add(new History(id, nickname, action, actingColumn, movedColumn, changedTime, contents));
    }

    public void addColumn(Long id, String title, LocalDateTime createdTime, List<Card> cards) {
        columns.add(new Columns(id, title, createdTime,cards));
    }
}
