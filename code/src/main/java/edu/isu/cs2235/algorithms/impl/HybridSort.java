package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySort;

import java.util.Arrays;

public class HybridSort implements ArraySort {
    /**
     * An interface for a generic array sort algorithm.
     *
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array) {
        if(array == null)
            throw new IllegalArgumentException("Array must not be null!");
        hybridSort(array, 0, array.length - 1);
    }

    private <E extends Comparable> void hybridSort(E[] array, int left, int right) {
        if(left < right) {
            int pi = partition(array, left, right);
        }
    }
}
