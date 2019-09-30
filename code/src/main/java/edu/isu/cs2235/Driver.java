package edu.isu.cs2235;

import edu.isu.cs2235.algorithms.impl.MergeSort;
import edu.isu.cs2235.algorithms.impl.QuickSort;
import edu.isu.cs2235.algorithms.impl.SelectionSort;
import edu.isu.cs2235.algorithms.impl.TimSort;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        TimSort sort = new TimSort();
        Integer[] array = {5, 4, 6, 2, 1};
        sort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
