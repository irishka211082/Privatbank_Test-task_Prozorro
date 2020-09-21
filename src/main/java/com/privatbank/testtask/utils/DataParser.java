package com.privatbank.testtask.utils;

import com.privatbank.testtask.converter.ToParentIdConverter;
import com.privatbank.testtask.domain.ClassifierItem;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataParser {

    private static final String CLASSIFIER_SERVICE_URL =
            "https://prozorroukr.github.io/standards/classifiers/dk021_uk.json";

    private static Map<String, String> getRawDataFromExternalService() {
        Map<String, String> rawData = new RestTemplate().getForObject(CLASSIFIER_SERVICE_URL, Map.class);
        return rawData;
    }

    private static List<ClassifierItem> parseRawClassifierDataToModels(Map<String, String> rawData) {
        List<ClassifierItem> classifierItemList = rawData.entrySet().stream()
                .map(es -> ClassifierItem.builder()
                        .id(es.getKey())
                        .name(es.getValue())
                        .type(TypeUtil.getClassifierType(es.getKey()))
                        .parentId(ToParentIdConverter.convertToParentId(
                                es.getKey(),
                                TypeUtil.getClassifierType(es.getKey())))
                        .build())
                .collect(Collectors.toList());
        return classifierItemList;
    }

    public static List<ClassifierItem> parse() {
        Map<String, String> rawDataMap = getRawDataFromExternalService();
        return parseRawClassifierDataToModels(rawDataMap);
    }
}
