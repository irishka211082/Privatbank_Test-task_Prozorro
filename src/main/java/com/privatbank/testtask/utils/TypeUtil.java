package com.privatbank.testtask.utils;

import com.privatbank.testtask.domain.ClassifierType;

public class TypeUtil {
    public static ClassifierType getClassifierType(String id) {
        char[] chars = id.toCharArray();

        if ("0".equalsIgnoreCase(String.valueOf(chars[2]))) return ClassifierType.SECTION;
        else if ("0".equalsIgnoreCase(String.valueOf(chars[3]))) return ClassifierType.GROUP;
        else if ("0".equalsIgnoreCase(String.valueOf(chars[4]))) return ClassifierType.CLASS;
        else if ("0".equalsIgnoreCase(String.valueOf(chars[5]))) return ClassifierType.CATEGORY;
        else return ClassifierType.ITEM;
    }
}
