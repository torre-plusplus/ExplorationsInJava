
package textfilereverser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 * Program that reverses text files and outputs them to a new file.
 * @author olnorton
 */
public class TextFileReverser {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        FileReader file = null;
        
        PrintWriter out = null;
        
        try {
            out = new PrintWriter("reversed");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextFileReverser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File selectedFile = chooser.getSelectedFile();
            
            try {
                file = new FileReader(selectedFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TextFileReverser.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Scanner in = new Scanner(file);
            while (in.hasNextLine()){
                String line = in.nextLine();
                String output = "";
                
                for (int i = 0; i <= line.length() -1; i++){
                    output += line.substring(line.length() -1 - i, line.length() - i);
                    
                }
                
                System.out.println(output);
                out.println(output);
                
            }
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(TextFileReverser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        out.close();
 
    }
    
}
