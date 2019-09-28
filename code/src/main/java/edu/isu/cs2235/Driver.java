package edu.isu.cs2235;

import edu.isu.cs2235.algorithms.impl.QuickSort;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        Integer[] array = {5, 4, 3, 2, 1};
        sort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
