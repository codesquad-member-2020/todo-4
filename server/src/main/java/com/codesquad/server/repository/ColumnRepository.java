package com.codesquad.server.repository;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.repository.CrudRepository;

public interface ColumnRepository extends CrudRepository<Column, Long> {

}
