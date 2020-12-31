package com.backstage.repairsystem.repository;

import com.backstage.repairsystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface PersonRepository extends JpaRepository<Person, Integer> {
    //登录验证1---验证是否有此用户Id
    List<Person> findAll();

}
