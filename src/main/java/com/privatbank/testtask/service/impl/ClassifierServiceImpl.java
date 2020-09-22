package com.privatbank.testtask.service.impl;

import com.privatbank.testtask.dao.ItemDao;
import com.privatbank.testtask.domain.ClassifierItem;
import com.privatbank.testtask.service.ClassifierService;
import com.privatbank.testtask.utils.DataParser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ClassifierServiceImpl implements ClassifierService {

    private final ItemDao itemDao;

    public ClassifierItem saveItemToDb(ClassifierItem item) {
        log.info("Try to add a new Item with id {} to database.", item.getId());
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
        log.debug("The item with id {} was found", id);
        return item;
    }

    public List<ClassifierItem> getAllRecords(){
        log.info("Try to get all items from database.");
        List<ClassifierItem> items = itemDao.getAllItems();
        log.debug("There are {} items were found.", items.size());
        return items;
    }

    public List<ClassifierItem> getChildren(String id) {
        log.info("Try to get all children for item with id {}.", id);
        ClassifierItem item = getItemById(id);

        if (item.getType().getValue() == 5) {
            List<ClassifierItem> children = itemDao.getChildrenOfItem(item.getParentId());
            log.debug("Children for item with id {} were found successfully", id);
            return children;
        }
        return null;
    }

    public List<ClassifierItem> updateRecords(List<ClassifierItem> classifierItemList) {
        log.info("Try to update items in database.");
        for (ClassifierItem item : classifierItemList) {
            itemDao.removeItem(item.getId());
        }
        log.debug("All previous items were removed from database.");

        List<ClassifierItem> updatedItems = saveAllItemsToDb();
        log.debug("{} items were updated successfully", updatedItems.size());
        return updatedItems;
    }
}
