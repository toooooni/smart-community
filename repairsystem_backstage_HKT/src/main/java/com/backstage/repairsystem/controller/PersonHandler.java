package com.backstage.repairsystem.controller;

import com.backstage.repairsystem.entity.Person;
import com.backstage.repairsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @param name
     * @param password
     * @param tel
     * @param email
     * @param userTypes
     * @return personId
     * 备注:postman测试成功
     * @role 用户注册
     */
    @PostMapping("/register")
    public Integer register(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("tel") String tel, @RequestParam("email") String email, @RequestParam("userTypes") Integer userTypes) {
        Person person = new Person();
        person.setName(name);
        person.setPassword(password);
        person.setTel(tel);
        person.setEmail(email);
        person.setUserTypes(userTypes);
        Person registerList = personRepository.save(person);
        return registerList.getPersonId();
    }

//    /**
//     * @role 用户注册
//     * @param name
//     * @param password
//     * @param tel
//     * @param email
//     * @param userTypes
//     * @return personId
//     * 备注:postman测试失败,成功注册但仅返回状态码
//     */
//    @PostMapping("/register")
//    public ResponseEntity<Object> register(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("tel") String tel, @RequestParam("email") String email, @RequestParam("userTypes") Integer userTypes) {
//        Person person = new Person();
//        person.setName(name);
//        person.setPassword(password);
//        person.setTel(tel);
//        person.setEmail(email);
//        person.setUserTypes(userTypes);
//        Person registerList = personRepository.save(person);
//        return new ResponseEntity<>(registerList.getPersonId(),HttpStatus.OK);
//    }

    /**
     * @param person
     * @return -1/-2/-3/0 [用户未注册：-3，密码错误：-2，用户身份错误：-3，登录成功：1]
     * 备注：暂时未在postman中测试
     * 备注：返回值与接口文档预期不符,建议返回ResponseEntity,如select
     * 备注：了解更多ResponseEntity，https://www.jianshu.com/p/e52253c05366
     * 备注：了解更多ResponseEntity，https://blog.csdn.net/neweastsun/article/details/81142870
     * @role 用户登录
     */
    @PostMapping("/login")
    public Integer login(@RequestParam("person") Person person) {
        Integer personId = person.getPersonId();
        String password = person.getPassword();
        Integer userTypes = person.getUserTypes();
        if (personRepository.findByPersonId(personId).isEmpty()) {
            return -1;
        } else if (personRepository.findByPersonIdAndPassword(personId, password).isEmpty()) {
            return -2;
        } else if (personRepository.findByPersonIdAndPasswordAndUserTypes(personId, password, userTypes).isEmpty()) {
            return -3;
        } else {
            return 1;
        }
    }

    /**
     * @param personId
     * @return {null,NOT_FOUND}/{用户信息，OK} [用户未找到/找到该用户]
     * 备注：已经在postman中测试
     * @role 查询用户
     */
    @PostMapping("/select")
    public ResponseEntity<Object> select(@RequestParam("personId") Integer personId) {
        List<Person> selectList = personRepository.findByPersonId(personId);
        if (selectList.isEmpty()) {
            return new ResponseEntity<>("", HttpStatus.OK);
        } else {
            Person person = selectList.get(0);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
    }
}
