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
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
public class RepairForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键formId为自增
    //报修单号、报修人Id、是否公用、物品属性、维修备注、地址、电话、付费情况、维修状态、日期、评价星级、评价内容
    private Integer formId;
    private Integer personId;
    private boolean whetherPublic;
    private String title;
    private BigDecimal price;
    private String author;
    private String publisher;
    private String ownerId;
    private String type;
}