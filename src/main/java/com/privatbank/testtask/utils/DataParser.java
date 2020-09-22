package com.privatbank.testtask.utils;

import com.privatbank.testtask.converter.ToParentIdConverter;
import com.privatbank.testtask.domain.ClassifierItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class DataParser {

    private static final String CLASSIFIER_SERVICE_URL =
            "https://prozorroukr.github.io/standards/classifiers/dk021_uk.json";

    private static Map<String, String> getRawDataFromExternalService() {
        log.info("Try to get raw data from the external service.");
        Map<String, String> rawData = new RestTemplate().getForObject(
                CLASSIFIER_SERVICE_URL,
                Map.class
        );
        if (Objects.nonNull(rawData)) {
            log.debug("Data was got from external service successfully!");
        }
        return rawData;
    }

    private static List<ClassifierItem> parseRawClassifierDataToModels(Map<String, String> rawData) {
        log.info("Try to parse raw classifier data to models.");
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
        if (Objects.nonNull(classifierItemList)) {
            log.debug("Data was parsed successfully!");
        }
        return classifierItemList;
    }

    public static List<ClassifierItem> parse() {
        log.info("Try to parse JSON to list of models.");
        Map<String, String> rawDataMap = getRawDataFromExternalService();
        return parseRawClassifierDataToModels(rawDataMap);
    }
}
