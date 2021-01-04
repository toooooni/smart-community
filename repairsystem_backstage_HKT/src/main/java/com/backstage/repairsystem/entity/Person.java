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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键PersonIdr为自增
    //用户Id、用户名、密码、电话、邮件、用户身份
    private Integer PersonId;
    private String name;
    private String password;
    private String tel;
    private String email;
    private Integer userTypes;

//    public Person(Integer id,String name,String password,String tel,String email,Integer type){
//        this.PersonId = id;
//        this.name = name;
//        this.email = email;
//    }
}