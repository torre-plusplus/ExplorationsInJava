
package phonedbsortsearch;

/**
 * Program that reads a data set of phone numbers and names from a file and allows
 * look up by name or number via quick sorting and binary searching.
 * @author torre
 */
public class PhoneDBSortSearch {

    public static void main(String[] args) {
        //NAME and NUMBER to search DB for
        String name = "Birchal";
        String number = "86-(706)733-5833";
        
        PhoneMatrix matrix = new PhoneMatrix();
        String result = matrix.lookUpNumber(name);
        System.out.println(result);
        
        result = matrix.lookUpName(number);
        System.out.println(result);
    }
    
}
