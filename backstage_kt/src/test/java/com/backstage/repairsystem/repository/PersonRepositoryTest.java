package com.backstage.repairsystem.repository;

import com.backstage.repairsystem.entity.Person;d
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PersonRepository.class)
class PersonRepositoryTest {
    @Autowired
    private  PersonRepository personRepository;

    //测试查询全表
    @Test
    void findAll(){
        System.out.println(personRepository.findAll());
    }

}