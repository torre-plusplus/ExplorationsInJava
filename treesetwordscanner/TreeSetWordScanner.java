
package treesetwordscanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Program that parses words from a text file and adds them to a tree file to
 * find all unique words.
 * @author torre
 */
public class TreeSetWordScanner {

    public static void main(String[] args) {
        Scanner in = new Scanner("");
        
        try {
            FileReader file = new FileReader("applemaf.txt");
            in = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TreeSetWordScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        Set<String> tree = new TreeSet<>();
        
        
        while(in.hasNext()){
            //if(!in.next().contains("*"))
                tree.add(in.next());
            
        }
        System.out.println("SET OF UNIQUE WORDS FROM INPUT: ");
        
        for (String e: tree){
            System.out.println(e);
        }
        System.out.println("SIZE OF SET: " + tree.size());
        
    }
    
}
