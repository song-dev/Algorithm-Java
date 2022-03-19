package com.song.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1213 三个有序数组的交集
 * 三个严格递增有序数组求交集
 */
public class LeetCode1213_ArraysIntersection {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int min;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                min = Math.min(Math.min(arr1[i], arr2[j]), arr3[k]);
                if (arr1[i] == min) {
                    i++;
                }
                if (arr2[j] == min) {
                    j++;
                }
                if (arr3[k] == min) {
                    k++;
                }
            }
        }
        return result;
    }

}
