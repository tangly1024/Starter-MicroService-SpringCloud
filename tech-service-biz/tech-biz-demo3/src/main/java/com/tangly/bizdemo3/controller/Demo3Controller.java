package com.tangly.bizdemo3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo3Controller {
    @GetMapping("demo3")
    public ResponseEntity<String> get(String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
