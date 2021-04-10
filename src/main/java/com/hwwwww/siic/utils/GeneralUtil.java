package com.hwwwww.siic.utils;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/10 22:22
 */
public class GeneralUtil {
    public static String addZero(String str, Integer len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("0");
        }
        sb.append(str);
        return sb.toString();
    }
}
