package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigReader {

    private static final String path = "src/config/config.json";

    public static JsonObject getJsonObject (){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(br, JsonObject.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
