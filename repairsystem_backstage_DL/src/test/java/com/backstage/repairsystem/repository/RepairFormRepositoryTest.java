package com.backstage.repairsystem.repository;

import com.backstage.repairsystem.entity.RepairForm;
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

    }

    @Test
    void findWithFormId(){
        System.out.println(repairFormRepository.findRepairFormByFormIdIsAfter(1));
    }

    @Test
    void save(){
        Integer personId = 3;
        String itemType = "lift";
        String message = null;
        String address = "XUST";
        String tel = "1563";
        RepairForm repairForm = new RepairForm();
        repairForm.setPersonId(personId);
        repairForm.setItemType(itemType);
        repairForm.setMessage(message);
        repairForm.setAddress(address);
        repairForm.setTel(tel);
        repairForm.setFormId(3);
        System.out.println(repairForm);
        System.out.println("test");
        RepairForm saveText = repairFormRepository.save(repairForm);
        System.out.println(saveText);
    }
}