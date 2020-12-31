package com.backstage.repairsystem;

import com.backstage.repairsystem.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepairsystemApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    //测试查询全表
    @Test
    void findAll(){
        System.out.println(personRepository.findAll());
    }

    @Test
    void contextLoads() {
    }

}
