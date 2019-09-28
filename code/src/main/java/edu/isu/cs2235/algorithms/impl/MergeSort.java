package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySort;

import java.util.Arrays;

public class MergeSort implements ArraySort {
    /**
     * An interface for a generic array sort algorithm.
     *
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array) {
        E[] copy = copyArray(array);
        mergeSort(copy, array, 0, array.length);
    }

    public <E extends Comparable> void mergeSort(E[] array, E[] result, int start, int end) {
        if(end == start)
            return;

        if(end - start < 2){
            if(result[start].compareTo(result[end]) > 0)
                swap(result, start, end);

            return;
        }
        int mid = (end - start) / 2 + start;
        mergeSort(result, array, start, mid);
        mergeSort(result, array, mid + 1, end);
        int i = start;
        int j = mid + 1;
        for(int index = 0; index < end; index++) {
            if(j > end || (i <= mid && array[i].compareTo(array[j]) < 0)) {
                result[index] = array[i];
                i++;
            } else {
                result[index] = array[j];
                j++;
            }
        }
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
