package com.privatbank.testtask.converter;

import com.privatbank.testtask.domain.Pair;
import com.privatbank.testtask.domain.Record;
import com.privatbank.testtask.domain.Type;
import com.privatbank.testtask.util.TypeValidator;

public class ToRecordConverter {

    public static Record convertPairToRecord(Pair pair) {
        Type type = TypeValidator.checkType(pair.getId());
        Record record = new Record(pair.getId(), pair.getName(), type);

        if (!type.equals(Type.SECTION)) {
            String parentId = ToParentIdConverter.convertToParentId(pair.getId(), type);
            record.setParentId(parentId);
        }
        return record;
    }
}
