package edu.xust.repairservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MI
 * @version 1.0
 * @description
 * @date 2020/12/29 15:31
 **/
@Controller
public class LoginController {
    @GetMapping("login")
    public ResponseEntity<Boolean> login(@RequestParam(name = "id")Integer id, @RequestParam(name = "password")String password){

    }

    @GetMapping("logout")
    public ResponseEntity<Boolean> logout(@RequestParam(name = "id") Integer id){

    }
}
