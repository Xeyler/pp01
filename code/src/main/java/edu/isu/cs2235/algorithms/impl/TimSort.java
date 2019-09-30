package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySort;

import java.util.Arrays;

public class TimSort implements ArraySort {
    /**
     * An interface for a generic array sort algorithm.
     *
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array) {
        if(array == null)
            throw new IllegalArgumentException("Array must not be null!");
        E[] copy = copyArray(array);
        mergeSort(copy, array, 0, array.length - 1);
    }

    public <E extends Comparable> void mergeSort(E[] array, E[] result, int start, int end) {
        if(end == start)
            return;

        if(end - start < 10){
            insertionSortRange(result, start, end);
            return;
        }
        int mid = (end - start) / 2 + start;
        mergeSort(result, array, start, mid);
        mergeSort(result, array, mid + 1, end);
        int i = start;
        int j = mid + 1;
        for(int index = start; index <= end; index++) {
            if(j > end || (i <= mid && array[i].compareTo(array[j]) < 0)) {
                result[index] = array[i];
                i++;
            } else {
                result[index] = array[j];
                j++;
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

    private <E> void swap(E[] array, int first, int second) {
        E temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Constructs an exact copy of the input array
     * @param otherArray The array to copy
     * @param <E> The type of parameter of the data in the array
     * @return A copy of the provided array
     */
    public <E> E[] copyArray(E[] otherArray) {
        return Arrays.copyOf(otherArray, otherArray.length);
    }

}
