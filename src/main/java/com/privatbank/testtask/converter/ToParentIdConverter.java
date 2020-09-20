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
        int REDIX = 10;
        char[] chars = new char[10];
        for (int i = 0; i < 8; i++) {
            chars[i] = Character.forDigit(parentNumsId[i], REDIX);
        }
        chars[8] = '-';
        chars[9] = Character.forDigit(parentControlNumber, REDIX);

        return String.valueOf(chars);
    }

    private static int[] convertToNums(char[] chars) {
        int[] nums = new int[8];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(String.valueOf(chars[i]));
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

    private static int[] prepareCategoryId(int[] nums) {
        nums[7] = 0;
        nums[6] = 0;
        nums[5] = 0;
        return nums;
    }

    private static int[] prepareClassId(int[] nums) {
        nums[4] = 0;
        return nums;
    }

    private static int[] prepareGroupId(int[] nums) {
        nums[3] = 0;
        return nums;
    }

    private static int[] prepareSectionId(int[] nums) {
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
