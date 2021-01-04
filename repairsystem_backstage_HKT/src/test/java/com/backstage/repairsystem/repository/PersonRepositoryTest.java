package com.backstage.repairsystem.repository;

import com.backstage.repairsystem.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author HKT
 * @date 2021/1/4 11:42
 */
@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void findAll() {
        System.out.println(personRepository.findAll());
    }

    /**
     * 用户注册测试
     */
    @Test
    void register() {
        Person person = new Person();
        person.setName("用户名test");
        person.setPassword("密码test");
        person.setTel("电话test");
        person.setEmail("邮箱test");
        person.setUserTypes(0);
        Person registerList = personRepository.save(person);
        System.out.println(registerList.getPersonId());
    }

    /**
     * 用户登录测试
     * 流程：
     * 查询是否有此personId
     * 验证personId是否与password匹配
     * 验证账密是否与userTypes匹配
     */
    @Test
    void login() {
        Integer personId = 1;
        String password = "1";
        Integer userTypes = 0;
        if (personRepository.findByPersonId(personId).isEmpty()) {
            System.out.println("用户名错误");
        } else if (personRepository.findByPersonIdAndPassword(personId, password).isEmpty()) {
            System.out.println("密码错误");
        } else if (personRepository.findByPersonIdAndPasswordAndUserTypes(personId, password, userTypes).isEmpty()) {
            System.out.println("用户身份错误");
        } else {
            System.out.println("登录成功");
            System.out.println(personRepository.findByPersonId(personId));
        }
    }

    /**
     * 查询用户信息
     */
    @Test
    void select() {
        Integer personId = 1;
        if (personRepository.findByPersonId(personId).isEmpty()) {
            System.out.println("没有此用户");
        } else {
            System.out.println(personRepository.findByPersonId(personId));
        }
    }
}