INSERT INTO `repairdb`.`person` (`person_id`, `name`, `password`, `tel`, `email`, `user_types`)
VALUES ('1', '丁磊', '1', '110', '110@qq.com', '-1');
INSERT INTO `repairdb`.`person` (`person_id`, `name`, `password`, `tel`, `email`, `user_types`)
VALUES ('2', '何坤廷', '2', '110', '110@qq.com', '0');
INSERT INTO `repairdb`.`person` (`person_id`, `name`, `password`, `tel`, `email`, `user_types`)
VALUES ('3', '陈佳超', '3', '110', '110@qq.com', '1');
INSERT INTO `repairdb`.`repairform` (`form_id`, `person_id`, `whetherPublic`, `itemType`, `message`, `address`, `tel`,
                                     `whetherPay`, `stateRepair`, `repairDate`, `evaluationStar`, `evaluationNote`)
VALUES ('1', '1', '0', '家电', '无', '西安科技大学', '110', '1', '0', '2020-12-28', '1', '无');