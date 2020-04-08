package com.codesquad.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Column {

    private Long id;
    private String name;
    private int previousColumnId;

    @Override
    public String toString() {
        return "Column{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", previousColumnId=" + previousColumnId +
                '}';
    }
}
