package com.privatbank.testtask.converter;

import com.privatbank.testtask.domain.ClassifierType;

public class ToParentIdConverter {

    private static final int[] indexes = {3, 7, 1, 3, 7, 1, 3, 7};

    public static String convertToParentId(String childId, ClassifierType type) {
        if (ClassifierType.SECTION.equals(type)) return null;

        char[] chars = childId.toCharArray();
        int[] childNums = convertToNums(chars);
        int[] parentNumsId = prepareParentId(childNums, type);
        int parentControlNumber = getControlNumber(parentNumsId);
        return prepareStringParentId(parentNumsId, parentControlNumber);
    }

    private static String prepareStringParentId(int[] parentNumsId, int parentControlNumber) {
        char[] chars = new char[10];
        for (int i = 0; i < 8; i++) {
            chars[i] = (char) parentNumsId[i];
        }
        chars[8] = '-';
        chars[9] = (char) parentControlNumber;

        return String.valueOf(chars);
    }

    private static int[] convertToNums(char[] chars) {
        int[] nums = new int[8];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = chars[i];
        }
        return nums;
    }

    private static int[] prepareParentId(int[] childNums, ClassifierType type) {
        if (type.equals(ClassifierType.ITEM)) {
            return prepareCategoryId(childNums);
        } else if (type.equals(ClassifierType.CATEGORY)) {
            return prepareClassId(childNums);
        } else if (type.equals(ClassifierType.CLASS)) {
            return prepareGroupId(childNums);
        } else if (type.equals(ClassifierType.GROUP)) {
            return prepareSectionId(childNums);
        }
        return null;
    }

    private static int[] prepareItemId(int[] nums) {
        nums[8] = 0;
        nums[7] = 0;
        nums[6] = 0;
        return nums;
    }

    private static int[] prepareCategoryId(int[] nums) {
        nums = prepareItemId(nums);
        nums[5] = 0;
        return nums;
    }

    private static int[] prepareClassId(int[] nums) {
        nums = prepareCategoryId(nums);
        nums[4] = 0;
        return nums;
    }

    private static int[] prepareGroupId(int[] nums) {
        nums = prepareClassId(nums);
        nums[3] = 0;
        return nums;
    }

    private static int[] prepareSectionId(int[] nums) {
        nums = prepareGroupId(nums);
        nums[2] = 0;
        return nums;
    }

    private static int getControlNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * indexes[i];
        }
        return sum % 10;
    }
}
