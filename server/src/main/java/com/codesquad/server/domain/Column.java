package com.codesquad.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Column {

    @Id
    private Long id;
    private String title;
    private Long previousId;

    private List<Card> cards = new ArrayList<>();

    public Column (String title) {
        this.title = title;
    }

    public void addCard(String note) {
        cards.add(new Card(note));
    }
}
