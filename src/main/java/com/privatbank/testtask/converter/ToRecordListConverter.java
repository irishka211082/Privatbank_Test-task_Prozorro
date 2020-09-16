package com.privatbank.testtask.converter;

import com.privatbank.testtask.domain.Pair;
import com.privatbank.testtask.domain.Record;

import java.util.ArrayList;
import java.util.List;

public class ToRecordListConverter {

    public static List<Record> convertToList(List<Pair> pairList) {
        List<Record> recordList = new ArrayList<>();
        for (Pair pair : pairList) {
            Record record = ToRecordConverter.convertPairToRecord(pair);
            recordList.add(record);
        }
        return recordList;
    }
}
