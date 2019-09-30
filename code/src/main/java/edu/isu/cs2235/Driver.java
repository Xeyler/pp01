package edu.isu.cs2235;

import edu.isu.cs2235.algorithms.impl.*;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        HybridSort sort = new HybridSort();
        Integer[] array = {5, 4, 6, 2, 1, 4, 2, 9, 8, 7, 1, 0, 4, 2, 7, 9};
        sort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
