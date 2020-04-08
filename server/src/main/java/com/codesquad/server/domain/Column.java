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
public class Column {

    @Id
    private Long id;
    private String name;

    public Column (String name) {
        this.name = name;
    }
}
