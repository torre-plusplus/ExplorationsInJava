
package arraysorting;

import java.util.Arrays;

/**
 * Main class that creates a random array and compares the efficiency of multiple
 * sorting algorithms on the array.
 * @author torre
 */
public class SortingAlgorithmComparison {

    public static void main(String[] args) {
        
        //size of set to be sorted.
        int n = 10000;
        
        System.out.println("Selection Sort: ");
        int[] a = ArrayUtil.randomIntArray(n, 100);
        //System.out.println(Arrays.toString(a));
        
        SelectionSorter sorter = new SelectionSorter(a);
        long startTime = System.currentTimeMillis();
        sorter.sort();
        long endTime = System.currentTimeMillis();
        //System.out.println(Arrays.toString(a));
        System.out.println("Sorting time: " + (endTime - startTime) + " ms.");
        
        System.out.println("Merge Sort: ");
        int[] b = ArrayUtil.randomIntArray(n, 100);
        //System.out.println(Arrays.toString(b));
        
        MergeSorter mSorter = new MergeSorter(b);
        startTime = System.currentTimeMillis();
        mSorter.sort();
        endTime = System.currentTimeMillis();
        //System.out.println(Arrays.toString(b));
        System.out.println("Sorting time: " + (endTime - startTime) + " ms.");
        
        System.out.println("Quick Sort: ");
        int[] c = ArrayUtil.randomIntArray(n, 100);
        //System.out.println(Arrays.toString(c));
        
        QuickSort qSorter = new QuickSort(c);
        startTime = System.currentTimeMillis();
        qSorter.sort(0, c.length - 1);
        endTime = System.currentTimeMillis();
        //System.out.println(Arrays.toString(c));
        System.out.println("Sorting time: " + (endTime - startTime) + " ms.");
        
        System.out.println("Java Arrays.sort: ");
        int[] d = ArrayUtil.randomIntArray(n, 100);
        //System.out.println(Arrays.toString(c));
        
        startTime = System.currentTimeMillis();
        Arrays.sort(d);
        endTime = System.currentTimeMillis();
        //System.out.println(Arrays.toString(c));
        System.out.println("Sorting time: " + (endTime - startTime) + " ms.");
    }
    
}
