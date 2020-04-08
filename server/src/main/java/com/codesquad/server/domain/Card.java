package com.codesquad.server.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private Long id;
    private String note;
    private int previousCardId;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", previousCardId=" + previousCardId +
                '}';
    }
}
