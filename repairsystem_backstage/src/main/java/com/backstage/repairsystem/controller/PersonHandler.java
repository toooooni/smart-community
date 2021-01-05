package com.backstage.repairsystem.controller;

import com.backstage.repairsystem.entity.Person;
import com.backstage.repairsystem.entity.Result;
import com.backstage.repairsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HKT
 * @date 2021/1/4 17:39
 */
@RestController
@RequestMapping("/person")
public class PersonHandler {
    @Autowired
    private PersonRepository personRepository;

    /**
     * findAll测试
     */
    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    /**
     * 用户注册
     *
     * @param name
     * @param password
     * @param tel
     * @param email
     * @param userTypes
     * @return result code:1
     * result msg:"登录成功"
     * result data:personId
     */
    @PostMapping("/register")
    public Result register(@RequestParam("name") String name, @RequestParam("password") String password,
                           @RequestParam("tel") String tel, @RequestParam("email") String email,
                           @RequestParam("userTypes") Integer userTypes) {
        //注册用户并返回personId
        Person person = new Person();
        person.setName(name);
        person.setPassword(password);
        person.setTel(tel);
        person.setEmail(email);
        person.setUserTypes(userTypes);
        Person responseList = personRepository.save(person);
        person.setPersonId(responseList.getPersonId());
        //装配result
        Result result = new Result();
        result.setCode(1);
        result.setMsg("注册成功");
        result.setData(person.getPersonId());
        return result;
    }

    /**
     * 用户登录
     *
     * @param personId
     * @param password
     * @param userTypes
     * @return result code:-1/-2/-3/0 [用户未注册：-3，密码错误：-2，用户身份错误：-3，登录成功：1]
     * result msg:用户未注册/密码错误/用户身份错误/登录成功
     * result data:person全表[password置空]
     */
    @PostMapping("/login")
    public Result login(@RequestParam("personId") Integer personId, @RequestParam("password") String password,
                        @RequestParam("userTypes") Integer userTypes) {
        Result result = new Result();
        Person person;
        if (personRepository.findByPersonId(personId).isEmpty()) {
            result.setCode(-1);
            result.setMsg("该用户未注册");
        } else if (personRepository.findByPersonIdAndPassword(personId, password).isEmpty()) {
            result.setCode(-2);
            result.setMsg("该用户密码错误");
        } else if (personRepository.findByPersonIdAndPasswordAndUserTypes(personId, password, userTypes).isEmpty()) {
            result.setCode(-3);
            result.setMsg("该用户身份错误");
        } else {
            person = personRepository.findByPersonId(personId).get(0);
            person.setPassword("");
            result.setCode(1);
            result.setMsg("登录成功");
            result.setData(person);
        }
        return result;
    }
}
