package com.privatbank.testtask.util;

import com.privatbank.testtask.domain.ClassifierType;

public class TypeValidator {
    public static ClassifierType checkType(String id) {
        char[] chars = id.toCharArray();
        if (chars[2] == 0) return ClassifierType.SECTION;
        else if (chars[3] == 0) return ClassifierType.GROUP;
        else if (chars[4] == 0) return ClassifierType.CLASS;
        else if (chars[5] == 0) return ClassifierType.CATEGORY;
        else return ClassifierType.ITEM;
    }
}
