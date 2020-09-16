package com.privatbank.testtask.util;

import com.privatbank.testtask.domain.Type;

public class TypeValidator {
    public static Type checkType(String id) {
        char[] chars = id.toCharArray();
        if (chars[2] == 0) return Type.SECTION;
        else if (chars[3] == 0) return Type.GROUP;
        else if (chars[4] == 0) return Type.CLASS;
        else if (chars[5] == 0) return Type.CATEGORY;
        else return Type.ITEM;
    }
}
