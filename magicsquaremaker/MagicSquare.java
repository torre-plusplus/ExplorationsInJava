
package magicsquaremaker;

/**
 * Constructs and outputs a magic square based on user input.
 * @author olnorton
 */
public class MagicSquare {
    
    /**
     * Constructs square and fills it with 0's.
     * @param n height/width of magic square.
     */
    public MagicSquare (int n){
        square = new int[n][n];
        
        for (int i = 0; i < square.length; i++){
            for (int j = 0; j < square.length; j++)
                square[i][j] = 0;
        }
    }
    
    public void drawSquare (){
        
        String r = "";
        for (int i = 0; i < square.length; i++){
            for (int j = 0; j < square.length; j++){
                if (square[i][j] < 10)
                    r = r + " ";
                if (square.length > 10 && square[i][j] < 100)
                    r = r + " ";
                if (square.length > 31 && square[i][j] < 1000)
                    r = r + " ";
                r = r + square[i][j] + " ";
            }
            r = r + "\n";
        }
        
        System.out.println(r);
        
    }
    
    public void buildSquare (){
        
        int y = (square.length -1 )/2;
        int x = square.length -1;
        
        for(int i = 1; i <= (square.length * square.length); i++){
            
            if(x == square.length && y == square.length){
                x--;
                square[x][y] = i;
            }
            else if (square[x][y] == 0)
                square[x][y] = i;
            else {
                x = (x + square.length -2) % square.length;
                y = (y + square.length -1) % square.length;
                square[x][y] = i;
            }
            
            x++;
            y++;
            x = x % (square.length);
            y = y % (square.length);
  
        }
        
        this.drawSquare();
        
        int sum = 0;
        for (int[] square1 : square) {
            sum += square1[0];
        }
        
        System.out.println("Sum of each row, column and diagonal is " + sum);
            
            
    }
    
    private int[][] square;
}
