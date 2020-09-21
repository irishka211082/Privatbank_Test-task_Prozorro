package com.privatbank.testtask.service;

import com.privatbank.testtask.domain.ClassifierItem;

import java.util.List;

public interface ClassifierService {

    ClassifierItem saveRecordToDb(ClassifierItem classifierItem);

    void saveAllRecordsToDb();

    ClassifierItem getRecordById(String recordId);

    List<ClassifierItem> getAllRecords();

    List<ClassifierItem> getChildren(String recordId);

    void updateRecords(List<ClassifierItem> classifierItemList);
}
