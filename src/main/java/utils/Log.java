package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;


public class Log {

    private static Logger logger= LogManager.getLogger();

    public static void startTestCase(String sTestCaseName){
        logger.info(String.format("*********************       %s       *********************", sTestCaseName));
        logger.info(String.format("%s : Test has been initialized.", sTestCaseName));

    }
    public static void endTestCase(String sTestCaseName){
        logger.info(String.format("%s : Test has been completed.", sTestCaseName));
    }
    public static void info(String message) {
        logger.info(message);
    }
    public static void warn(String message) {
        logger.warn(message);
    }
    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }
    public static void debug(String message) {
        logger.debug(message);
    }
}
