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
