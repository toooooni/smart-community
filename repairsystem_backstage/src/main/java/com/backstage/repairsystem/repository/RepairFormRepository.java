package com.backstage.repairsystem.repository;

/**
 * @author DL
 * @date 2020/12/31 14:56
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.backstage.repairsystem.entity.RepairForm;

import java.util.List;

public interface RepairFormRepository extends JpaRepository<RepairForm,Integer>{

    List<RepairForm> findRepairFormByFormId(Integer formId);
    List<RepairForm> findRepairFormByPersonId(Integer PersonId);
//    List<RepairForm> findByFormId(Integer formId);

}
