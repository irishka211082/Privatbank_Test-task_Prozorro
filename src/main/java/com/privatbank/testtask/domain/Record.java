package com.privatbank.testtask.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Record {
    private String recordId;
    private String recordName;
    private Type type;
    private String parentId;

    public Record(String recordId, String recordName, Type type) {
        this.recordId = recordId;
        this.recordName = recordName;
        this.type = type;
    }
}
