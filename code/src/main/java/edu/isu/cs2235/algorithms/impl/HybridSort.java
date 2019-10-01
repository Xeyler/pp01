package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySort;

import java.util.Arrays;

public class HybridSort extends QuickSort {

    @Override
    public <E extends Comparable> void quickSort(E[] array, int left, int right) {
        if(left < right) {
            if(right - left < 10) {
                insertionSortRange(array, left, right);
            } else {
                int pi = partition(array, left, right);
                quickSort(array, left, pi - 1);
                quickSort(array, pi + 1, right);
            }
        }
    }

    private <E extends Comparable> void insertionSortRange(E[] array, int start, int end) {
        for(int i = start; i <= end; i++) {
            insert(array, i, array[i], start);
        }
    }

    private <E extends Comparable> void insert(E[] array, int pos, E value, int start) {
        int i = pos - 1;
        while(i >= start && array[i].compareTo(value) > 0) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
    }
}
