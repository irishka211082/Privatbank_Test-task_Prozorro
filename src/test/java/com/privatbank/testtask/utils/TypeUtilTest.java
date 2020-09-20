package com.privatbank.testtask.utils;

import com.privatbank.testtask.domain.ClassifierType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeUtilTest {

    @Test
    void checkSectionType(){
        ClassifierType expectedType = ClassifierType.SECTION;
        ClassifierType actualType = TypeUtil.getClassifierType("03000000-1");

        assertEquals(expectedType, actualType);
    }

    @Test
    void checkGroupType(){
        ClassifierType expectedType = ClassifierType.GROUP;
        ClassifierType actualType = TypeUtil.getClassifierType("03100000-2");

        assertEquals(expectedType, actualType);
    }

    @Test
    void checkClassType(){
        ClassifierType expectedType = ClassifierType.CLASS;
        ClassifierType actualType = TypeUtil.getClassifierType("03110000-5");

        assertEquals(expectedType, actualType);
    }

    @Test
    void checkCategoryType(){
        ClassifierType expectedType = ClassifierType.CATEGORY;
        ClassifierType actualType = TypeUtil.getClassifierType("03111000-2");

        assertEquals(expectedType, actualType);
    }

    @Test
    void checkItemType(){
        ClassifierType expectedType = ClassifierType.ITEM;
        ClassifierType actualType = TypeUtil.getClassifierType("03111300-5");

        assertEquals(expectedType, actualType);
    }
}