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
        if(left >= right)
            return;
        if(right - left < 10) {
            insertionSortRange(array, left, right);
            return;
        }
        int pi = partition(array, left, right);
        hybridSort(array, left, pi);
        hybridSort(array, pi + 1, right);
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

    private <E extends Comparable> int partition(E[] array, int left, int right) {
        E pivot = array[left];

        int i = left + 1;
        int j = right;
        while(i <= j) {
            if(array[i].compareTo(pivot) > 0 && array[j].compareTo(pivot) <= 0) {
                swap(array, i, j);
                i++;
                j--;
            } else {
                if(array[i].compareTo(pivot) <= 0) {
                    i++;
                }
                if(array[j].compareTo(pivot) > 0) {
                    j--;
                }
            }
        }
        return j;
    }

    private <E> void swap(E[] array, int first, int second) {
        E temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
