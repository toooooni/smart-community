package com.backstage.repairsystem.entity;

/**
 * @author HKT
 * @date 2020/12/30 15:08
 */

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键personId为自增
    //Id、用户名、密码、电话、邮箱、用户身份
    private Integer personId;
    private String name;
    private String password;
    private String tel;
    private String email;
    private Integer userTypes;
}
