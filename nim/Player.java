
package nim;

import java.util.Random;
import java.util.Scanner;

/**
 * Constructs player of smart, stupid or human difficulty and calls methods
 * of Pile class to take marbles.
 * @author olnorton
 */
public class Player {
    
    public Player (int type){
        switch (type) {
            case 1:
                playerType = Type.SMART;
                break;
            case 2:
                playerType = Type.RANDOM;
                break;
            default:
                playerType = Type.HUMAN;
                break;
        }
    }
    
    public int takeTurn(int pile){
        int taken = 1;
        boolean properInput = false;
        switch (playerType){
            case SMART:
               if (pile == 1 || pile == 2 || pile == 3 || pile == 7 || pile == 15 || 
                       pile == 31 || pile == 63)
                   taken = 1;
               else if (pile < 7)
                   taken = Math.abs(3-pile);
               else if (pile < 15)
                   taken = Math.abs(7-pile);
               else if (pile < 31)
                   taken = Math.abs(15-pile);
               else if (pile < 63)
                   taken = Math.abs(31-pile);
               else
                   taken = Math.abs(63-pile);
               return taken;
            case RANDOM:
                if (pile == 1 || pile == 2 || pile == 3)
                    return 1;
                else
                    return (generator.nextInt(pile/2 - 1) + 1);
            default:
                while (!properInput){
                    System.out.println("Enter number of marbles to take: ");
                    taken = in.nextInt();
                    
                    if (taken == 1)
                        properInput = true;
                    else if (taken <= 0)
                        properInput = false;
                    else if (taken > pile/2)
                        properInput = false;
                    else
                        properInput = true;
                    
                    if (properInput == false){
                        System.out.println("Illegal input. Cannot take more than "
                                + "half of pile or a negative number.");
                    }
                }
                return taken;
        }
    }
    
    Random generator = new Random();
    Scanner in = new Scanner(System.in);
    public enum Type {HUMAN, SMART, RANDOM}; 
    public Type playerType;
}
