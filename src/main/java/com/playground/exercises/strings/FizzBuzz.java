package main.java.com.playground.exercises.strings;

import main.java.com.playground.utils.LoggerUtil;

/*
Problem statement:
If an int is divisible by 3, return "fizz".
If it is divisible by 5, return "buzz".
If divisible by both print "fizzbuzz".
 */

public class FizzBuzz {
    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    public static String fizzBuzz(int number) {
        /* Sanity Check - Return if negative integer */
        if (number < 0) {
            return "";
        }

        StringBuilder result = new StringBuilder("");

        if (number % 3 == 0) {
            result.append(FIZZ);
        }
        if (number % 5 == 0) {
            result.append(BUZZ);
        }

        return result.toString();
    }

    public static void testFizzBuzz() {
        LoggerUtil.info("Testing FizzBuzz...");

        LoggerUtil.assertEquals("fizz", FizzBuzz.fizzBuzz(3), "3 should be fizz");
        LoggerUtil.assertEquals("buzz", FizzBuzz.fizzBuzz(5), "5 should be buzz");
        LoggerUtil.assertEquals("fizzbuzz", FizzBuzz.fizzBuzz(15), "15 should be fizzbuzz");
        LoggerUtil.assertEquals("", FizzBuzz.fizzBuzz(2), "2 should be empty");
        LoggerUtil.assertEquals("", FizzBuzz.fizzBuzz(-1), "-1 should be empty");
        LoggerUtil.assertEquals("fizzbuzz", FizzBuzz.fizzBuzz(0), "0 should be fizzbuzz (divisible by 3 and 5)");

        LoggerUtil.info("All FizzBuzz tests passed!");
    }
}
