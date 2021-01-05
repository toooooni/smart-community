package com.backstage.repairsystem.repository;

import com.backstage.repairsystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author HKT DL
 * @date 2021/1/4 11:39
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    /**
     * @param personId
     * @return 返回该用户信息
     */
    List<Person> findByPersonId(Integer personId);

    /**
     * @param personId
     * @param password
     * @return 返回该用户信息
     */
    List<Person> findByPersonIdAndPassword(Integer personId, String password);

    /**
     * @param personId
     * @param password
     * @param userTypes
     * @return 返回该用户信息
     */
    List<Person> findByPersonIdAndPasswordAndUserTypes(Integer personId, String password, Integer userTypes);

    List<Person> findPersonByPersonId(Integer PersonId);
}
