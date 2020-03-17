package com.example.demo.util;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-17 23:10
 */
public class ParamUtil {

    private ParamUtil() {
    }

    public static boolean checkNumbers(Integer... numbers) {
        for (Integer number : numbers) {
            if (number == null || number == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkString(String... strings) {
        for (String string : strings) {
            if (string == null || string.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
