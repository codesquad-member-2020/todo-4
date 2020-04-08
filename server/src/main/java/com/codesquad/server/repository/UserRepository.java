package com.codesquad.server.repository;

import com.codesquad.server.domain.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM user WHERE user_id = :userId")
    Optional<User> findUserByUserId(String userId);

    @Query("SELECT count(*) FROM column WHERE user = :userId")
    int countColumnforUser(Long userId);
}
