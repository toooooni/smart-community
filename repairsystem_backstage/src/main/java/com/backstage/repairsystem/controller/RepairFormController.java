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

import java.util.ArrayList;
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
    public Result commitRepairForm(Integer personId,String itemType,String message,
                                    String address,String tel){
        /**
         * 提交维修单,其中whether_public直接由用户类型确定
         * @param personId 用户id
         * @param itemType 维修物品类型
         * @param message 备注
         * @param address 地址
         * @param tel 联系电话
         * @return result{
         *     code: 1 成功  -1 失败
         *     msg: 提示信息
         *     data：{ formId }
         * }
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
        Result result = new Result();
        result.setCode(1);
        result.setMsg("提交成功");
        result.setData(repairForm.getFormId());
        return result;
//        return 1;
    }


    @PostMapping(value = "/findform")
    public Result findForm(Integer formId){
        Result result = new Result();
        List<RepairForm> data =repairFormRepository.findRepairFormByFormId(formId);
        if (data.isEmpty()){
            result.setCode(-1);
            result.setMsg("未找到目标报修单");
        }
        else {
            result.setCode(1);
            result.setMsg("提交成功");
            result.setData(data );
        }
        return result;
    }

    @PostMapping(value = "/modifyform")
    public Result modifyForm(Integer formId,boolean whetherPay,Integer stateRepair,Integer evaluationStar,
                              String evaluationNote){
        List<RepairForm> nowForm = repairFormRepository.findRepairFormByFormId(formId);
        int length = nowForm.size();
        int index=0;
        Result result = new Result();
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
                result.setCode(-2);
                result.setMsg("用户类型错误!");
                return result;
            }
            if (userType == 1)
                newForm.setWhetherPay(true);
            repairFormRepository.save(newForm);
        }
        result.setCode(1);
        result.setMsg("修改成功");
        result.setData(formId);
        return result;
    }

    @PostMapping(value = "/rearchFormId")
    public Result findFormIdWithPersonId(Integer personId){
        List<RepairForm> personList = repairFormRepository.findRepairFormByPersonId(personId);
        List<Integer> formIdList = new ArrayList();
        int index;
        for (index=0;index<personList.size();index++){
            int temp= personList.get(index).getFormId();
            formIdList.add(temp);
        }
//        System.out.println(formIdList);
        Result result = new Result();
        if(formIdList.isEmpty())
        {
            result.setCode(-1);
            result.setMsg("未找到该用户提交的formId");
        }
        else {
            result.setCode(1);
            result.setMsg("以下为所有该用户提交的formId");
        }

        result.setData(formIdList );
        return result;
    }
    public int findUserType(Integer personId){
        Person user = (personRepository.findPersonByPersonId(personId)).get(0);
        return user.getUserTypes();
    }


}
