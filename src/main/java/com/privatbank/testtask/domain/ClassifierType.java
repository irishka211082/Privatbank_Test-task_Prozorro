package com.privatbank.testtask.domain;

public enum ClassifierType {
    SECTION(1), GROUP(2), CLASS(3), CATEGORY(4), ITEM(5);

    private final int value;

    ClassifierType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
