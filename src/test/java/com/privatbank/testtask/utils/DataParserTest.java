package com.privatbank.testtask.utils;

import com.privatbank.testtask.domain.ClassifierItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {

    @Test
    void getDataFromExternalJson() {
        List<ClassifierItem> actualItems = DataParser.parse();

        assertEquals(9458, actualItems.size());
        assertEquals("98395000-8", actualItems.get(9443).getId());
        assertEquals("Арахіс", actualItems.get(5).getName());
    }
}