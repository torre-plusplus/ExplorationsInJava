
package arraysorting;

import java.util.Random;

/**
 * Class that creates an array of a given length and populates it with random 
 * integers.
 * @author torre
 */
public class ArrayUtil {
    
    public static int[] randomIntArray(int length, int maxValue){
        
        
        int[] a = new int[length];
        
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.nextInt(maxValue);
        }
        return a;
    }
    
    private static Random generator = new Random();
}
