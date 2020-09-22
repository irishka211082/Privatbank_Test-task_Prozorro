package com.privatbank.testtask.utils;

import com.privatbank.testtask.domain.ClassifierType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TypeUtil {
    public static ClassifierType getClassifierType(String id) {
        log.info("Try to get type of item");
        char[] chars = id.toCharArray();

        if ("0".equalsIgnoreCase(String.valueOf(chars[2]))) {
            log.debug("Found that item has SECTION-type");
            return ClassifierType.SECTION;
        } else if ("0".equalsIgnoreCase(String.valueOf(chars[3]))) {
            log.debug("Found that item has GROUP-type");
            return ClassifierType.GROUP;
        } else if ("0".equalsIgnoreCase(String.valueOf(chars[4]))) {
            log.debug("Found that item has CLASS-type");
            return ClassifierType.CLASS;
        } else if ("0".equalsIgnoreCase(String.valueOf(chars[5]))) {
            log.debug("Found that item has CATEGORY-type");
            return ClassifierType.CATEGORY;
        } else
            log.debug("Found that item has ITEM-type");
        return ClassifierType.ITEM;
    }
}
