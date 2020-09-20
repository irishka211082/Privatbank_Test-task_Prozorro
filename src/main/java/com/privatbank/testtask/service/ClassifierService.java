package com.privatbank.testtask.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.privatbank.testtask.domain.ClassifierType;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Map;

@Service
public class ClassifierService {

    private static final String TEMP_DATA_FROM_REGISTRY = "{\n" +
            "    \"03000000-1\": \"Сільськогосподарська, фермерська продукція, продукція рибальства, лісівництва та супутня продукція\", \n" +
            "    \"03100000-2\": \"Сільськогосподарська продукція та продукція рослинництва\", \n" +
            "    \"03110000-5\": \"Сільськогосподарські культури, продукція товарного садівництва та рослинництва\", \n" +
            "    \"03111000-2\": \"Насіння\"\n" +
            "}";

    private String getJsonFromRegistry() {
        return TEMP_DATA_FROM_REGISTRY;
    }

    private String getClassifierDataFromJson(String json) {
        Gson gson = new Gson();

        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> records = gson.fromJson(json, type);


        return null;
    }


    public static ClassifierType getType(String id) {
        char[] chars = id.toCharArray();
        if (chars[2] == 0) return ClassifierType.SECTION;
        else if (chars[3] == 0) return ClassifierType.GROUP;
        else if (chars[4] == 0) return ClassifierType.CLASS;
        else if (chars[5] == 0) return ClassifierType.CATEGORY;
        else return ClassifierType.ITEM;
    }



}
