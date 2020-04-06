package com.codesquad.todo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    private String userId;

    private String password;
}
