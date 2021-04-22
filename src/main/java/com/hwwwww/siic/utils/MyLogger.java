package com.hwwwww.siic.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/22 9:53
 */
@Slf4j
public class MyLogger {
    public static void info(String infoMessage) {
        log.info(infoMessage);
    }

    public static void info(String infoMessage, Object... args) {
        log.info(infoMessage, args);
    }

    public static void info(String infoMessage, Throwable throwable) {
        log.info(infoMessage, throwable);
    }

    public static void warning(String warningMessage) {
        log.warn(warningMessage);
    }

    public static void warning(String warningMessage, Object... args) {
        log.warn(warningMessage, args);
    }

    public static void warning(String warningMessage, Throwable throwable) {
        log.warn(warningMessage, throwable);
    }

    public static void error(String errorMessage) {
        log.warn(errorMessage);
    }

    public static void error(String errorMessage, Object... args) {
        log.warn(errorMessage, args);
    }

    public static void error(String errorMessage, Throwable throwable) {
        log.warn(errorMessage, throwable);
    }

}
