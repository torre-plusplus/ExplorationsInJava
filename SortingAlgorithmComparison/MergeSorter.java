
package arraysorting;

/**
 * Class that sorts an array using the Merge Sort algorithm.
 * @author torre
 */
public class MergeSorter {
    
    public MergeSorter (int[] anArray) {
        a = anArray;
    }
    /**
     * Recursively sorts the array by splitting it into single element arrays and
     * then reconstructing as sorted pairs of arrays.
     */
    public void sort(){
        if (a.length <= 1)
            return ;
        
        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];
        System.arraycopy(a, 0, first, 0, first.length);
        System.arraycopy(a, first.length, second, 0, second.length);
        MergeSorter firstSorter = new MergeSorter(first);
        MergeSorter secondSorter = new MergeSorter(second);
        firstSorter.sort();
        secondSorter.sort();
        merge(first, second);
    }
    
    /**
     * Merges two sorted arrays into the array managed by this merge sorter.
     * @param first first array to merge
     * @param second second array to merge
     */
    private void merge(int[] first, int[] second){
        //merge both halves into a temporary array
        
        
        int iFirst = 0; //next element considered in first array
        
        int iSecond = 0; //next element considered in second array
        
        int j = 0; //next open position in final array
        
        //Copy smaller element into []a, as long as 1st and 2nd are in bounds
        while (iFirst < first.length && iSecond < second.length){
            if (first[iFirst] < second[iSecond]){
                a[j] = first[iFirst];
                iFirst++;
            }
            else {
                a[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        
        //Copies any remaining elements from either first or second to []a
        System.arraycopy(first, iFirst, a, j, first.length-iFirst);
        System.arraycopy(second, iSecond, a, j, second.length - iSecond);
    }
    
    private int[] a;
}
