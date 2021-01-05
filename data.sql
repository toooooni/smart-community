INSERT INTO `repairdb`.`person` (`person_id`, `name`, `password`, `tel`, `email`, `user_types`)
VALUES ('1', '业主', '1', '110', '110@qq.com', '0');
INSERT INTO `repairdb`.`person` (`person_id`, `name`, `password`, `tel`, `email`, `user_types`)
VALUES ('2', '物业人员', '2', '110', '110@qq.com', '1');
INSERT INTO `repairdb`.`person` (`person_id`, `name`, `password`, `tel`, `email`, `user_types`)
VALUES ('3', '维修人员', '3', '110', '110@qq.com', '2');
INSERT INTO `repairdb`.`repair_form` (`form_id`, `person_id`, `whether_public`, `item_type`, `message`, `address`, `tel`,
                                     `whether_pay`, `state_repair`, `repair_date`, `evaluation_star`, `evaluation_note`)
VALUES ('1', '1', '0', '家电', '无', '西安科技大学', '110', '1', '0', '2020-12-28', '1', '无');