package com.privatbank.testtask.service.impl;

import com.privatbank.testtask.dao.ItemDao;
import com.privatbank.testtask.dao.impl.ItemDaoImpl;
import com.privatbank.testtask.domain.ClassifierItem;
import com.privatbank.testtask.service.ClassifierService;
import com.privatbank.testtask.utils.DataParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassifierServiceImpl implements ClassifierService {

    private final ItemDao itemDao;

    public ClassifierItem saveRecordToDb(ClassifierItem item) {
        itemDao.createItem(item.getId(), item.getName(), item.getType().getValue(), item.getParentId());
        return null;
    }

    public void saveAllRecordsToDb() {
        List<ClassifierItem> classifierItemList = DataParser.parse();
        for (ClassifierItem item : classifierItemList) {
            saveRecordToDb(item);
        }
    }

    public ClassifierItem getRecordById(String id) {
        return itemDao.getItemById(id);
    }

    public List<ClassifierItem> getAllRecords(){
        return itemDao.getAllItems();
    }

    public List<ClassifierItem> getChildren(String id) {
        ClassifierItem item = getRecordById(id);
        if (item.getType().getValue() == 5) {
            return itemDao.getChildrenOfItem(item.getParentId());
        }
        return null;
    }

    public void updateRecords(List<ClassifierItem> classifierItemList) {
        for (ClassifierItem item : classifierItemList) {
            itemDao.removeItem(item.getId());
        }
        saveAllRecordsToDb();
    }
}
