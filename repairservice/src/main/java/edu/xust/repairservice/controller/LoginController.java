package edu.xust.repairservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.xust.repairservice.pojo.LogInfo;
import edu.xust.repairservice.pojo.LogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author MI
 * @version 1.0
 * @description
 * @date 2020/12/29 15:31
 **/
@Controller
public class LoginController {

    ObjectMapper MAPPER = new ObjectMapper();
    @Autowired
    StringRedisTemplate redisTemplate;
    @GetMapping("login")
    public ResponseEntity<Boolean> login(@RequestParam(name = "id")Integer id, @RequestParam(name = "password")String password) throws JsonProcessingException {
    }

    @GetMapping("logout")
    public ResponseEntity<Boolean> logout(@RequestParam(name = "id") Integer id){
        return null;
    }
}
