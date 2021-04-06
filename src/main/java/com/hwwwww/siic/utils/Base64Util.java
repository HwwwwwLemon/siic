package com.hwwwww.siic.utils;

import org.springframework.stereotype.Component;

import java.util.Base64;

/**
 * @author Hwwwww
 */
@Component
public class Base64Util {
    private static String SALT = "Hwwwww";
    private static final int REPEAT = 5;

    public static String encode(String str) {
        String tmp = str + "((" + SALT + "))";
        byte[] data = tmp.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            data = Base64.getEncoder().encode(data);
        }
        return new String(data);
    }

    public static String decode(String str) {
        byte[] data = str.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            data = Base64.getDecoder().decode(data);
        }
        return new String(data).replace("((" + SALT + "))", "");
    }

    public static void setSalt(String salt) {
        SALT = salt;
    }
}
