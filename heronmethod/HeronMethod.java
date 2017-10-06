
package heronmethod;

import java.util.Scanner;

/**
 * Method that approximates the square root of number a through iteration of
 * subsequently more accurate estimates.
 * @author olnorton
 */
public class HeronMethod {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        final double EPSILON = 0.01;
        
        System.out.println("Enter value to estimate square root for: ");
        double userValue = in.nextDouble();
        double estimate = 1;
        boolean stillGuessing = true;
        
        while (stillGuessing){
            double newEstimate = (userValue/estimate + estimate)/2;
            System.out.println(newEstimate);
            if (Math.abs(newEstimate - estimate) < EPSILON)
                stillGuessing = false;
            estimate = newEstimate;
        }
        
        double roundEstimate = (Math.round(estimate * 1000))/1000;
        
        System.out.println("Final estimation of square root is " + roundEstimate);
        
    }
    
}
