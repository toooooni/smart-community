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

    @Autowired
    private PersonRepository personRepository;

    @PostMapping(value = "/commit")
    public Integer commitRepairForm(Integer personId,String itemType,String message,
                                    String address,String tel){
        /**
         * 提交维修单,其中whether_public直接由用户类型确定
         * @param personId 用户id
         * @param itemType 维修物品类型
         * @param message 备注
         * @param address 地址
         * @param tel 联系电话
         * @return 1 正常
         *        -1 error
         */
//        System.out.println("测试");
        RepairForm repairForm = new RepairForm();
        repairForm.setPersonId(personId);
        repairForm.setItemType(itemType);
        repairForm.setMessage(message);
        repairForm.setAddress(address);
        repairForm.setTel(tel);
//        System.out.println(user);
        int type = findUserType(personId);
        if ( type == 1)
            repairForm.setWhetherPublic(true);
        else repairForm.setWhetherPublic(false);
        repairFormRepository.save(repairForm);
        return 1;
    }

    @PostMapping(value = "/findform")
    public List<RepairForm> findForm(Integer formId){
        return repairFormRepository.findRepairFormByFormId(formId);
    }

    @PostMapping(value = "/modifyform")
    public Integer modifyForm(Integer formId,boolean whetherPay,Integer stateRepair,Integer evaluationStar,
                              String evaluationNote){
        List<RepairForm> nowForm = repairFormRepository.findRepairFormByFormId(formId);
        int length = nowForm.size();
        int index=0;
        List<RepairForm> newList ;
        for (index=0;index<length;index++)
        {
            RepairForm newForm;
            newForm = nowForm.get(index);
            System.out.println(newForm);
            int userType = findUserType(newForm.getPersonId());
            if ( userType == 1 || userType == 0){
                // 对业主和物业

                newForm.setEvaluationStar(evaluationStar);
                newForm.setEvaluationNote(evaluationNote);
            }
            else if (userType == 2){
                //对维修人员
                newForm.setWhetherPay(whetherPay);
                newForm.setStateRepair(stateRepair);
            }
            else{
                System.out.println("用户类型错误!");
                return -2;
            }
            if (userType == 1)
                newForm.setWhetherPay(true);
            repairFormRepository.save(newForm);
        }

        return 1;
    }

    public int findUserType(Integer personId){
        Person user = (personRepository.findPersonByPersonId(personId)).get(0);
        return user.getUserTypes();
    }

}
