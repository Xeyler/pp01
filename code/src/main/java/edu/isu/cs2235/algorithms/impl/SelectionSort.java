package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySort;

import java.util.Arrays;

public class SelectionSort implements ArraySort {
    /**
     * An interface for a generic array sort algorithm.
     *
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array) {
        if(array == null)
            throw new IllegalArgumentException("Array must not be null!");
        for(int firstUnsorted = 0; firstUnsorted <= array.length - 1; firstUnsorted++) {
            int min = firstUnsorted;
            int i;
            for(i = min; i <= array.length - 1; i++) {
                if(array[i].compareTo(array[min]) < 0)
                    min = i;
            }
            swap(array, firstUnsorted, min);
        }
    }

    private <E> void swap(E[] array, int first, int second) {
        E temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
