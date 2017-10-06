
package recursivestringreverser;

/**
 *
 * @author torre
 */
public class Reverser {
    public Reverser(String aSentence){
        sentence = aSentence;
    }
    
    public String reverse(){
        if(sentence.length() <= 1) return sentence;
        
        char first = sentence.charAt(0);
        sentence = sentence.substring(1);
        return reverse() + first;
    }
    
   
    
    private String sentence;
}
