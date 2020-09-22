package com.privatbank.testtask.service;

import com.privatbank.testtask.domain.ClassifierItem;

import java.util.List;

public interface ClassifierService {

    ClassifierItem saveItemToDb(ClassifierItem classifierItem);

    List<ClassifierItem> saveAllItemsToDb();

    ClassifierItem getItemById(String recordId);

    List<ClassifierItem> getAllRecords();

    List<ClassifierItem> getChildren(String recordId);

    List<ClassifierItem> updateRecords(List<ClassifierItem> classifierItemList);
}
