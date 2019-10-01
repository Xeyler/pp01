package edu.isu.cs2235;

import edu.isu.cs2235.algorithms.ArraySort;
import edu.isu.cs2235.algorithms.impl.*;

import java.util.Arrays;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        ArraySort[] sortingAlgorithms = {new HybridSort(), new InsertionSort(), new MergeSort(), new QuickSort(), new SelectionSort(), new TimSort()};
        Random rng = new Random();

        System.out.print("arraySize");
        for(ArraySort sortingAlgorithm : sortingAlgorithms) {
            System.out.print(',' + sortingAlgorithm.getClass().getSimpleName());
        }
        System.out.println();

        for(int i = 10000; i <= 100000; i += 10000) {
            System.out.print(i);
            long averageTime = 0;
            for(ArraySort sortingAlgorithm : sortingAlgorithms) {
                for (int attempt = 0; attempt < 50; attempt++) {
                    Integer[] array = new Integer[i];
                    for (int j = 0; j < array.length; j++) {
                        array[j] = rng.nextInt(100000);
                    }
                    long startTime = System.nanoTime();
                    sortingAlgorithm.sort(array);
                    averageTime += System.nanoTime() - startTime;
                }
                averageTime /= 50;
                System.out.print(',');
                System.out.print(averageTime);
            }
            System.out.println();
        }
    }
}
