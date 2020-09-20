package com.privatbank.testtask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class JsonClassifier {

    private final Map<String, JsonClassifierItem> classifierItems;
}
