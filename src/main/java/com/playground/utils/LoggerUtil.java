package main.java.com.playground.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple logger utility for logging messages with timestamps and levels.
 */
public class LoggerUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void info(String message) {
        log("INFO", message);
    }

    public static void error(String message) {
        log("ERROR", message);
    }

    public static void debug(String message) {
        log("DEBUG", message);
    }

    public static void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println(String.format("[%s] [%s] %s", timestamp, level, message));
    }

    public static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " | Expected: " + expected + ", but got: " + actual);
        }
    }
}
