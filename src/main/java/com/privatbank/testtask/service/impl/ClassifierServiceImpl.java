package com.privatbank.testtask.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.privatbank.testtask.dao.ItemDao;
import com.privatbank.testtask.domain.ClassifierItem;
import com.privatbank.testtask.domain.ClassifierType;
import com.privatbank.testtask.exceptions.NoChildrenException;
import com.privatbank.testtask.exceptions.NoItemException;
import com.privatbank.testtask.exceptions.NoItemsException;
import com.privatbank.testtask.service.ClassifierService;
import com.privatbank.testtask.utils.DataParser;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ClassifierServiceImpl implements ClassifierService {

    private final ItemDao itemDao;

    public ClassifierItem saveItemToDb(ClassifierItem item) {
        log.debug("Try to add a new Item with id {} to database.", item.getId());
        itemDao.createItem(item.getId(), item.getName(), item.getType().getValue(), item.getParentId());

        ClassifierItem addedItem = itemDao.getItemById(item.getId());
        log.debug("The new entity with id {} was added successfully", item.getId());
        return addedItem;
    }

    public List<ClassifierItem> saveAllItemsToDb() {
        log.info("Try to add list of items from classifier to database.");
        List<ClassifierItem> classifierItemList = DataParser.parse();

        List<ClassifierItem> addedItems = new ArrayList<>();
        for (ClassifierItem item : classifierItemList) {
            addedItems.add(saveItemToDb(item));
        }
        log.debug("{} items were added to database successfully!", addedItems.size());
        return addedItems;
    }

    public ClassifierItem getItemById(String id) {
        log.info("Try to get item with id {} from database.", id);
        ClassifierItem item = itemDao.getItemById(id);
        if (Objects.isNull(item)) {
            throw new NoItemException();
        }
        return item;
    }

    public List<ClassifierItem> getAllRecords() {
        log.info("Try to get all items from database.");
        List<ClassifierItem> items = itemDao.getAllItems();
        if (Objects.nonNull(items)) {
            log.debug("There are {} items were found.", items.size());
        } else {
            throw new NoItemsException();
        }
        return items;
    }

    public List<ClassifierItem> getChildren(String id) {
        log.info("Try to get all children for item with id {}.", id);
        ClassifierItem item = getItemById(id);

        if (!item.getType().equals(ClassifierType.ITEM)) {
            List<ClassifierItem> children = itemDao.getChildrenOfItem(item.getParentId());
            if (Objects.isNull(children)) {
                throw new NoChildrenException();
            }
            return children;
        }

        throw new NoChildrenException();
    }

    public List<ClassifierItem> updateRecords() {
        log.info("Try to update all items in database.");
        truncateItemTable();
        return saveAllItemsToDb();
    }

    private void truncateItemTable() {
        log.info("Try to truncate \"item\" table.");
        itemDao.truncateTable();
        log.info("\"item\" table was successfully truncated.");
    }
}
