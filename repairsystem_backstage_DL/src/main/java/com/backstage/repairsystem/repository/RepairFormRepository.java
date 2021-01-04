package com.backstage.repairsystem.repository;

/**
 * @author DL
 * @date 2020/12/31 14:56
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.backstage.repairsystem.entity.RepairForm;

import java.util.List;

public interface RepairFormRepository extends JpaRepository<RepairForm,Integer>{

    List<RepairForm> findRepairFormByFormIdIsAfter(Integer formId);
//    List<RepairForm> findByFormId(Integer formId);

}
