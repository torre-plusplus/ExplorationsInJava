
package recursivestringreverser;

/**
 * Program that utilizes the reverser class to recursively reverse a string.
 * @author torre
 */
public class RecursiveStringReverser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reverser rever = new Reverser ("Nibbler!  What are you doing?");
        System.out.println(rever.reverse());
    }
    
}
