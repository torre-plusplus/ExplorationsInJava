
package word.permutator;

import java.util.ArrayList;

/**
 * Class that recursively finds permutations of a supplied string.
 * @author torre
 */
public class Permutator {
    public Permutator(String aWord){
        word = aWord;
    }
    
    public ArrayList <String> getPermutations(){
        ArrayList <String> results = new ArrayList<>();
        
        if (word.length() == 0) {
            results.add(word);
            return results;
        }
        
        for (int i = 0; i < word.length(); i++) {
            String shorterWord = word.substring(0, i) + word.substring(i + 1);
            
            Permutator shorterPermutator = new Permutator (shorterWord);
            ArrayList <String> shorterPermutations = 
                    shorterPermutator.getPermutations();
            
            for (String s : shorterPermutations)
                results.add(word.charAt(i) + s);
            
            
        }
        return results; 
    }
    
    private String word;
}
