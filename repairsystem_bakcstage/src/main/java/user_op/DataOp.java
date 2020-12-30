package user_op;

/**
 * @author DL
 * @date 2020/12/30
 */

public class DataOp {

    /**
     * 判断字符串是否属于数字
     * @param input s
     * @return is number?
     */
    private static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
