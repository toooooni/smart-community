package com.backstage.repairsystem.entity;

/**
 * @author HKT
 * @date 2020/12/30 15:09
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class RepairForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键formId为自增
    //报修单号、用户Id、是否公用区域、物品属性、维修备注、地址、电话、是否付费、维修状态、维修日期、评价星级、评价内容
    private Integer formId;
    private Integer personId;
    private boolean whetherPublic;
    private String itemType;
    private String message;
    private String address;
    private String tel;
    private boolean whetherPay;
    private Integer stateRepair;
    private Date repairDate;
    private Integer evaluationStar;
    private String evaluationNote;

}