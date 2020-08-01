package com.lucien.sakilaservice.controller;

import com.lucien.sakilaservice.constant.RequestPath;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = RequestPath.HELLO, produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "Hello";
    }

}
