
package magicsquaremaker;

import java.util.Scanner;

/**
 * Creates a magic square for a user supplied integer.
 * @author olnorton
 */
public class MagicSquareMaker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        
        while(!done){
            
            System.out.println("Enter an odd integer to use to form a magic square (-1 to exit): ");
            int n = in.nextInt();
            if(n <= 0 || n % 2 == 0)
                done = true;
            
            else {
                MagicSquare square = new MagicSquare(n);
                square.buildSquare();
                
            }
            
                
            
            
        }
    }
    
}
