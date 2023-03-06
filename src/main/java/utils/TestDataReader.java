package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestDataReader {
    private static Gson getGson(){
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
}
    public static User[] getUsersFromJson (){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/test_data/users.json"));
            return getGson().fromJson(br, User[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getFrameName(String frame){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/test_data/iFrames.json"));
            JsonObject jsonObject = getGson().fromJson(br, JsonObject.class);
            return jsonObject.get(frame).getAsString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
