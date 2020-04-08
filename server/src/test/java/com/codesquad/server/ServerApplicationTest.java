package com.codesquad.server;

import com.codesquad.server.domain.User;
import com.codesquad.server.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ServerApplicationTest {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private UserRepository userRepo;

    private Logger logger = LoggerFactory.getLogger(SpringBootTest.class);

    @Test
    void LoggerNotNull() {
        assertThat(logger).isNotNull();
        logger.debug("Logger Ok");
    }

    @Test
    void contextLoads() {
        assertThat(ctx).isNotNull();
        logger.debug("ApplicationContext is not null");
    }

    @Test
    void userRepo_FindById() {
        User user = userRepo.findById(1L).get();
        assertThat(user).isNotNull();
        logger.debug("Find user with Id 1: {}", user);
    }

    private void addUserColumn(User user) {
        user.addColumn("doing");
        user.addColumn("done");
        user.addColumn("todo");
    }

    private void printColumns(User user) {
        user.getColumns().stream().forEach(column -> {
            logger.debug("##### After save user and column: {}", column.getName());
        });
    }

    @Test
    void addGame() {
        User user = userRepo.findById(1L).get();
        addUserColumn(user);
        userRepo.save(user);
        assertThat(userRepo.countColumnforUser(user.getId())).isEqualTo(3);
        logger.debug("Add column - user info: {}", user);
        printColumns(user);
    }

    User getUserByUserId() {
        String userId = "ever";
        return userRepo.findUserByUserId(userId).get();
    }

    @Test
    void userRepo_FindByUserId() {
        User user = getUserByUserId();
        assertThat(user).isNotNull();
        logger.debug("#### Find user by UserId: {}", user);
    }

    @Test
    void userRepo_findByUserIdAndAddColumn() {
        String userId = "hamill210";
        User user = userRepo.findUserByUserId(userId).get();
        logger.debug("##### Find user by userId: {}, {}", userId, user);
        addUserColumn(user);
        userRepo.save(user);
        logger.debug("##### Find user by userId after save and add Column {}, {}", userId, user);
        printColumns(user);
    }
}
