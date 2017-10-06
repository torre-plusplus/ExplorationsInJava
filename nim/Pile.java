
package nim;

/**
 * Constructs and keeps a public total of number of marbles in the pile.
 * @author olnorton
 */
public class Pile {
    
    public Pile (int initialPile){
        remaining = initialPile;
    }
    
    public void takeMarbles(int take){
        remaining -= take;
    }
    
    
    public int remaining;
}
