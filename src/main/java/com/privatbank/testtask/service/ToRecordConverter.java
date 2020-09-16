package com.privatbank.testtask.service;

import com.privatbank.testtask.domain.Record;
import com.privatbank.testtask.domain.Type;
import com.privatbank.testtask.util.ToParentIdConverter;
import com.privatbank.testtask.util.TypeValidator;

public class ToRecordConverter {

    public Record convertJsonRowToRecord(String id, String name) {
        Type type = TypeValidator.checkType(id);
        Record record = new Record(id, name, type);

        if (!type.equals(Type.SECTION)) {
            String parentId = ToParentIdConverter.convertToParentId(id, type);
            record.setParentId(parentId);
        }
        return record;
    }
}
