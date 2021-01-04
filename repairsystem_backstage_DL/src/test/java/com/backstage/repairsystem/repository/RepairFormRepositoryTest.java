package com.backstage.repairsystem.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DL
 * @date 2020/12/31 15:15
 */

@SpringBootTest
class RepairFormRepositoryTest {
    @Autowired
    private RepairFormRepository repairFormRepository;

    @Test
    void findAll(){
        System.out.println(repairFormRepository.findAll());
//        System.out.println(repairFormRepository.findRepairFormByFormIdIsAfter(1));
    }
}