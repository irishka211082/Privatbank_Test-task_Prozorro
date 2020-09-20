package com.privatbank.testtask.service;

import com.privatbank.testtask.converter.ToParentIdConverter;
import com.privatbank.testtask.domain.ClassifierItem;
import com.privatbank.testtask.utils.TypeUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClassifierService {

    private static final String CLASSIFIER_SERVICE_URL =
            "https://prozorroukr.github.io/standards/classifiers/dk021_uk.json";

    public ClassifierItem saveRecordToDb(ClassifierItem classifierItem) {
        return classifierItem;
    }

    public void saveAllRecordsToDb() {
        Map<String, String> rawDataMap = getRawDataFromExternalService();
        List<ClassifierItem> classifierItemList = parseRawClassifierDataToModels(rawDataMap);
        for (ClassifierItem classifierItem : classifierItemList) {
            saveRecordToDb(classifierItem);
        }
    }

    public ClassifierItem getRecord(String recordId) {
        return null;
    }

    public List<ClassifierItem> getChildren(String recordId) {
        return null;
    }

    public void updateRecords(List<ClassifierItem> classifierItemList) {
    }

    private static Map<String, String> getRawDataFromExternalService() {
        Map<String, String> rawData = new RestTemplate().getForObject(CLASSIFIER_SERVICE_URL, Map.class);
        return rawData;
    }

    public static List<ClassifierItem> parseRawClassifierDataToModels(Map<String, String> rawData) {
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
}
