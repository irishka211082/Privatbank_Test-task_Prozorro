package com.privatbank.testtask.converter;

import com.privatbank.testtask.domain.ClassifierType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToParentIdConverterTest {

    @Test
    void checkGettingParentIdForItem() {
        String expectedParentId = "03113000-6";
        String actualParentId = ToParentIdConverter.convertToParentId("03113100-7", ClassifierType.ITEM);

        assertEquals(expectedParentId, actualParentId);
    }

    @Test
    void checkGettingParentIdForCategory() {
        String expectedParentId = "03110000-5";
        String actualParentId = ToParentIdConverter.convertToParentId("03115000-0", ClassifierType.CATEGORY);

        assertEquals(expectedParentId, actualParentId);
    }

    @Test
    void checkGettingParentIdForClass() {
        String expectedParentId = "03100000-2";
        String actualParentId = ToParentIdConverter.convertToParentId("03110000-5", ClassifierType.CLASS);

        assertEquals(expectedParentId, actualParentId);
    }

    @Test
    void checkGettingParentIdForGroup() {
        String expectedParentId = "03000000-1";
        String actualParentId = ToParentIdConverter.convertToParentId("03100000-2", ClassifierType.GROUP);

        assertEquals(expectedParentId, actualParentId);
    }

    @Test
    void checkGettingParentIdForSection() {
        String expectedParentId = null;
        String actualParentId = ToParentIdConverter.convertToParentId("03000000-1", ClassifierType.SECTION);

        assertEquals(expectedParentId, actualParentId);
    }
}