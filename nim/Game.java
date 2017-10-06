
package nim;

import java.util.Random;
import java.util.Scanner;

/**
 * Class that controls other elements of the game.  Constructs in one method and
 * controls turns and monitors win condition in another.
 * @author olnorton
 */
public class Game {
    
    /**
     * Initiates game, players and pile upon construction.
     */
    public Game (){
        System.out.println("Starting new game...");
        
        System.out.println("Enter type for Player 1 (1 = Smart, 2 = Random, "
                + " 3 = Human: ");
        int playerInt1 = in.nextInt();
        
        System.out.println("Enter type for Player 2 (1 = Smart, 2 = Random, "
                + " 3 = Human: ");
        int playerInt2 = in.nextInt();
        
        Player playerA = new Player(playerInt1);
        Player playerB = new Player(playerInt2);
        player1 = playerA;
        player2 = playerB;
        
        Pile pileA = new Pile((generator.nextInt(90) + 11));
        pile = pileA;
        String marbles = "";
        for (int i = 1; i <= pile.remaining; i++){
                marbles = marbles + "o";
                if (i % 10 == 0)
                    marbles += "\n";
        }
        System.out.println("\n\n\n\n\n\n\n" 
                + marbles + "\nPile Size: " + pile.remaining);
    }
    
    public void playGame () {
        
        boolean stillPlaying = true;
        int turnCounter = 1;
        
        while (stillPlaying){
            int taken;
            String marbles = "";
            if (turnCounter == 1){
                taken = player1.takeTurn(pile.remaining);
                System.out.println("\n\n\n\n\n\n\nPlayer 1 takes " + taken + " marbles.");
                pile.takeMarbles(taken);
                turnCounter++;
            }
            
            else if (turnCounter == 2){
                taken = player2.takeTurn(pile.remaining);
                System.out.println("\n\n\n\n\n\n\nPlayer 2 takes " + taken + " marbles.");
                pile.takeMarbles(taken);
                turnCounter--;
            }
            
            if (pile.remaining == 0){
                stillPlaying = false;
                System.out.println("0 Marbles remaining.");
                System.out.println("Player " + turnCounter + " wins!");    
            }
            else{
                for (int i = 1; i <= pile.remaining; i++){
                    marbles = marbles + "o";
                    if (i % 10 == 0)
                        marbles += "\n";
                }
                
                System.out.println(marbles);
                System.out.println(pile.remaining + " marbles remaining.");
            }
        }  
        
    }
    
    Player player1;
    Player player2;
    Pile pile;
    
    private Scanner in = new Scanner(System.in);
    private Random generator = new Random();
}
