package com.privatbank.testtask.converter;

import com.privatbank.testtask.domain.JsonClassifierItem;
import com.privatbank.testtask.domain.ClassifierItem;
import com.privatbank.testtask.domain.ClassifierType;
import com.privatbank.testtask.util.TypeValidator;

public class ToRecordConverter {

    public static ClassifierItem convertPairToRecord(JsonClassifierItem classifierItem) {
        ClassifierType type = TypeValidator.checkType(classifierItem.getId());
        ClassifierItem record = new ClassifierItem(classifierItem.getId(), classifierItem.getName(), type);

        if (!type.equals(ClassifierType.SECTION)) {
            String parentId = ToParentIdConverter.convertToParentId(classifierItem.getId(), type);
            record.setParentId(parentId);
        }
        return record;
    }
}
