package user_op;

import com.backstage.repairsystem.entity.*;
import com.backstage.repairsystem.repository.RepairFormRepository;

/**
 * @author DL
 * @date 2020/12/30
 */

public class DataOp {


    private static boolean isNumber(String input) {
        /**
         * 判断字符串是否属于数字
         * @param input s
         * @return is number?
         */
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static int commitRepairForm(Integer personId,String itemType,String message,
                                        String address,String tel){
        /**
         * @param personId 用户id
         * @param itemType 维修物品类型
         * @param message 备注
         * @param address 地址
         * @param tel 联系电话
         * @return 1 正常
         *        -1 error
         */
        RepairFormRepository repairFormRepository;
        RepairForm repairForm = new RepairForm();
            repairForm.setPersonId(personId);
            repairForm.setItemType(itemType);
            repairForm.setMessage(message);
            repairForm.setAddress(address);
            repairForm.setTel(tel);

        RepairForm saveText = repairFormRepository.save(repairForm);
        return 1;
    }

    private static int modifyRepairForm(Integer formId,Integer userTypes,boolean whetherPay,
                                        Integer stateRepair,Integer evaluationStar,String evaluationNote){
        /**
         *修改维修单状态
         * @param formId 维修单号
         * @param userTypes 0/1/2  [业主：0，物业人员：1，维修人员：2]
         * @param whetherPay 是否支付
         * @param stateRepair 1/2/3  [未维修/维修中/维修结束]
         * @param evaluationStar 评价星级
         * @param evaluationNote 评价内容
         * @return 0 修改成功
         *         -1 修改失败，订单未找到
         */
        if(userTypes == 0 || userTypes == 1){
            // 对业主和物业

        }
        if (userTypes == 2 ){
            //对维修人员
        }
        return 0;
    }
}
