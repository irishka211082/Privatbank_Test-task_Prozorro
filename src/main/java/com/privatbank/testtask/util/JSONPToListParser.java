package com.privatbank.testtask.util;

import com.privatbank.testtask.domain.Pair;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONPToListParser {

    public static List<Pair> parse() {

        String path = "C:\\Users\\Laptop PC\\Desktop\\МОЙ ДИСК\\Работа\\Тестовые\\prozorro-test-task\\src\\main\\" +
                "resources\\pr.json";
        String allText = getTextFromJSON(path);

        return parseTextToMap(allText);
    }

    public static void main(String[] args) {
    }

    private static String getTextFromJSON(String path) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get(path)));
            JSONObject obj = new JSONObject(contents);
            return obj.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static List<Pair> parseTextToMap(String text){
        List<Pair> pairList = new ArrayList<>();
        //ToDo:
        //parse text to pairs
        //put each pair to List

        return pairList;
    }
}
