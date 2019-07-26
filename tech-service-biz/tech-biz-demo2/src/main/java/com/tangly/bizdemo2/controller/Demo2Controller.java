package com.tangly.bizdemo2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo2Controller {
    @GetMapping("demo2")
    public ResponseEntity<String> get(String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
