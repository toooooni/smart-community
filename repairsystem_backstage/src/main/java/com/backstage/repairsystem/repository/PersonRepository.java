package com.backstage.repairsystem.repository;
import com.backstage.repairsystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author DL
 * @date 2021/1/4 10:14
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {

    List<Person> findPersonByPersonId(Integer PersonId);
}
