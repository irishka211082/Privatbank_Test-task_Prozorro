package com.privatbank.testtask.service;

import com.privatbank.testtask.converter.ToRecordListConverter;
import com.privatbank.testtask.domain.Pair;
import com.privatbank.testtask.domain.Record;
import com.privatbank.testtask.util.JSONPToListParser;

import java.util.List;

public class RecordService {

    public Record saveRecordToDb(Record record) {
        return record;
    }

    public void saveAllRecordsToDb() {
        List<Pair> pairs = JSONPToListParser.parse();
        List<Record> recordList = ToRecordListConverter.convertToList(pairs);
        for (Record record : recordList) {
            saveRecordToDb(record);
        }
    }

    public Record getRecord(String recordId) {
        return null;
    }

    public List<Record> getChildren(String recordId) {
        return null;
    }

    public void updateRecords(List<Record> recordList) {
    }
}
