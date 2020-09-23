package com.privatbank.testtask.dao;

import com.privatbank.testtask.domain.ClassifierItem;

import java.util.List;

public interface ItemDao {

    ClassifierItem createItem(String id, String name, int type, String parentId);

    ClassifierItem getItemById(String id);

    List<ClassifierItem> getAllItems();

    List<ClassifierItem> getChildrenOfItem(String parentId);

    void truncateTable();
}
