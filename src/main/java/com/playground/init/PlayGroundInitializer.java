package main.java.com.playground.init;

import main.java.com.playground.utils.ExerciseTypeEnum;
import main.java.com.playground.utils.LoggerUtil;
import test.java.com.playground.TestRunner;

public class PlayGroundInitializer {

    /**
     * Entry point of the application.
     */
    public static void main(String[] args) {
        LoggerUtil.info("PlayGroundInitializer initialized!");
        executeTestHarness();
    }

    public static void executeTestHarness() {
        LoggerUtil.info("Executing test harness!");
        TestRunner.runTestRunner(ExerciseTypeEnum.ALL);
    }

}
