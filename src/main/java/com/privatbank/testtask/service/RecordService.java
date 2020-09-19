package com.privatbank.testtask.service;

import com.privatbank.testtask.converter.ToRecordListConverter;
import com.privatbank.testtask.domain.FromJSONData;
import com.privatbank.testtask.domain.Pair;
import com.privatbank.testtask.domain.Record;
import com.privatbank.testtask.util.JSONPToListParser;

import java.util.List;

public class RecordService {

    public Record saveRecordToDb(Record record) {
        return record;
    }

    public void saveAllRecordsToDb() {
        FromJSONData data = getDataFromJson();
        List<Record> recordList = ToRecordListConverter.convertToList(data.getPairs());
        for (Record record : recordList) {
            saveRecordToDb(record);
        }
    }

    private FromJSONData getDataFromJson() {
        List<Pair> pairs = JSONPToListParser.parse();
        return new FromJSONData(pairs);
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
