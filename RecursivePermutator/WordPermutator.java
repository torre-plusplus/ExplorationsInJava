
package word.permutator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that recursively finds all the permutations of a user supplied string.
 * @author torre
 */
public class WordPermutator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        System.out.println("Enter a word to find permutations of: ");
        String userWord = in.next();
        Permutator permutations = new Permutator(userWord);
        ArrayList<String> results = new ArrayList<>();
        results = permutations.getPermutations();
        System.out.println("\nPermutations:");
        for(String s: results){
            System.out.println(s);
        }
    }
    
}
