package com.backstage.repairsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import com.backstage.repairsystem.entity.*;
import com.backstage.repairsystem.repository.*;

import java.util.List;

/**
 * @author DL
 * @date 2021/1/4 14:09
 */

@RestController
@RequestMapping("/repairform")
public class RepairFormController {
    @Autowired
    private RepairFormRepository repairFormRepository;

    @PostMapping(value = "/commit")
    public Integer commitRepairForm(Integer personId,String itemType,String message,
                                    String address,String tel){
        /**
         * 提交维修单
         * @param personId 用户id
         * @param itemType 维修物品类型
         * @param message 备注
         * @param address 地址
         * @param tel 联系电话
         * @return 1 正常
         *        -1 error
         */
        System.out.println("测试");
        RepairForm repairForm = new RepairForm();
        repairForm.setPersonId(personId);
        repairForm.setItemType(itemType);
        repairForm.setMessage(message);
        repairForm.setAddress(address);
        repairForm.setTel(tel);

        repairFormRepository.save(repairForm);
        return 1;
    }

    @PostMapping(value = "/findform")
    public List<RepairForm> findForm(Integer formId){
        return repairFormRepository.findRepairFormByFormId(formId);
    }

}
