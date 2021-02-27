package edu.xust.repairservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author MI
 * @version 1.0
 * @description
 * @date 2020/12/29 15:34
 **/
@Controller
public class RegisterController {

    @PostMapping
    public ResponseEntity<String> register(){
        return null;

    }
}
