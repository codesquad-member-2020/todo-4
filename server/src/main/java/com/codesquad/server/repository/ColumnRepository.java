package com.codesquad.server.repository;

import com.codesquad.server.domain.Column;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ColumnRepository extends CrudRepository<Column, Long> {
    @Query("SELECT * FROM column WHERE name = :name")
    Optional<Column> findColumnByName(String name);

    @Query("SELECT count(*) FROM card WHERE column = :columnName")
    int countColumnforUser(String columnName);
}
