package com.privatbank.testtask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class ClassifierItem {

    private final String id;
    private final String parentId;
    private final String name;
    private final ClassifierType type;
}
