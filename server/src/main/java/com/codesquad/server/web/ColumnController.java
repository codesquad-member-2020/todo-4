package com.codesquad.server.web;

import com.codesquad.server.repository.ColumnRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/columns")
public class ColumnController {

    private final Logger logger = LoggerFactory.getLogger(ColumnController.class);

    @Autowired
    ColumnRepository columnRepository;

//    @GetMapping("/")
//    public Column list() {
//
//
//        return "";
//    }

}
