package com.backstage.repairsystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DL
 * @date 2021/1/4 16:49
 */
@RestController
public class Helloword {

    @PostMapping("/hello")
    public String hello(){
        return "hello";
    }
}
