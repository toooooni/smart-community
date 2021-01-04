package com.backstage.repairsystem.controller;

import com.backstage.repairsystem.entity.Person;
import com.backstage.repairsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonHandler {
    @Autowired
    private PersonRepository personRepository;

    //findAll测试
    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
