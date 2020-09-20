package com.privatbank.testtask.converter;

import com.privatbank.testtask.domain.JsonClassifierItem;
import com.privatbank.testtask.domain.ClassifierItem;

import java.util.ArrayList;
import java.util.List;

public class ToRecordListConverter {

    public static List<ClassifierItem> convertToList(List<JsonClassifierItem> classifierItemList) {
        List<ClassifierItem> recordList = new ArrayList<>();
        for (JsonClassifierItem classifierItem : classifierItemList) {
            ClassifierItem record = ToRecordConverter.convertPairToRecord(classifierItem);
            recordList.add(record);
        }
        return recordList;
    }
}
