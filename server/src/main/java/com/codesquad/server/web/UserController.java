package com.codesquad.server.web;

import com.codesquad.server.domain.Column;
import com.codesquad.server.domain.User;
import com.codesquad.server.repository.ColumnRepository;
import com.codesquad.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @GetMapping("")
    public User index() {
        String userId = "hamill";
        User user = userRepository.findUserByUserId(userId).get();
        String name = "다했어";
        columnRepository.deleteById(2L);

        return user;
    }

}
