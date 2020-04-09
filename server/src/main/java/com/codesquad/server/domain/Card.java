package com.codesquad.server.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    private Long id;
    private String note;

    public Card(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", note='" + note + '\'' +
                '}';
    }
}
