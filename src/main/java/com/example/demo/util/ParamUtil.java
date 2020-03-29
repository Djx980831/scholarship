package com.example.demo.util;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-17 23:10
 */
public class ParamUtil {

    public static final String CHECK_STUDENT_ID = "(2)[\\d]{7,9}";

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

    public static boolean checkDouble(Double... numbers) {
        for (Double number : numbers) {
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

    public static boolean checkStudentId(String studentId) {
        if (studentId.matches(CHECK_STUDENT_ID)) {
            return true;
        }
        return false;
    }
}
