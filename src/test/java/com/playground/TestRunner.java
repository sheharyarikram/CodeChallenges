package test.java.com.playground;

import main.java.com.playground.utils.ExerciseTypeEnum;
import main.java.com.playground.utils.LoggerUtil;
import test.java.com.playground.exercises.StringsTester;

public class TestRunner {

    public static void runTestRunner(ExerciseTypeEnum exerciseType) {
        switch (exerciseType) {
            case ExerciseTypeEnum.ALL:
                runStringExerciseTests();
                break;
            case ExerciseTypeEnum.STRINGS:
                runStringExerciseTests();
                break;
            default:
                LoggerUtil.info("No exercises to run for the given type: " + exerciseType);
                break;
        }
    }

    public static void runStringExerciseTests() {
        LoggerUtil.info("Testing String exercises!");
        StringsTester.testStringExcercises();
        LoggerUtil.info("All String exercises passed!");
    }
}
