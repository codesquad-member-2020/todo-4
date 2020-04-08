package com.codesquad.server.repository;

import com.codesquad.server.domain.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {

}
