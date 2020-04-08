package com.codesquad.server.web;

import com.codesquad.server.domain.User;
import com.codesquad.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public User index() {
        String userId = "hamill210";
        User user = userRepository.findUserByUserId(userId).get();
        user.addColumn("doing");
        user.addColumn("do");
        user.addColumn("done");


        return userRepository.save(user);
    }

}
