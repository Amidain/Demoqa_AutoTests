package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomUtil {
    public static final int MAX_RND_STRING_LENGTH = 8;
    public static String getRandomString(){
        Log.info("Generate random string.");
        return RandomStringUtils.random(MAX_RND_STRING_LENGTH, true,true);
    }
}
