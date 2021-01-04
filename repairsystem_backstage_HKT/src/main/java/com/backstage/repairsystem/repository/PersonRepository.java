package com.backstage.repairsystem.repository;
import com.backstage.repairsystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author HKT
 * @date 2021/1/4 11:39
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
