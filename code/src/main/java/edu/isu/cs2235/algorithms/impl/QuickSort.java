package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySort;

import java.util.Arrays;

public class QuickSort implements ArraySort {
    /**
     * An interface for a generic array sort algorithm.
     *
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private <E extends Comparable> void quickSort(E[] array, int left, int right) {
        if(left < right) {
            int pi = partition(array, left, right);
            quickSort(array, left, pi - 1);
            quickSort(array, pi + 1, right);
        }
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
                if(array[j].compareTo(pivot) <= 0) {
                    j--;
                }
            }
        }

        swap(array, left, j);
        return j;
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
