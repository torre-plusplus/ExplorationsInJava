
package phonedbsortsearch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that 
 * @author torre
 */
public class PhoneMatrix {
    
    public PhoneMatrix (){
        try {
            FileReader file = new FileReader("MOCK_DATA.csv");
            Scanner in = new Scanner(file);
            int lineCounter = 0;
            in.nextLine(); //advance scanner past file headrs
            while(in.hasNextLine()){
                String lineIn = in.nextLine();
                Scanner commaIn = new Scanner (lineIn).useDelimiter(",");
                names[lineCounter][0] = commaIn.next() + ", " + commaIn.next();
                names[lineCounter][1] = commaIn.next();
                lineCounter++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhoneMatrix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sortNames(int from, int to){
        if (nameSorted == true)
            return;
        if (to <= from)
            return;
        else {
            int p = partitionNames(from, to);
            sortNames (from, p);
            sortNames (p+1, to);
        }
    }
    
    public void sortNumbers(int from, int to){
        if (numberSorted == true)
            return;
        if (to <= from)
            return;
        else{
            int p = partitionNumbers(from, to);
            sortNumbers(from, p);
            sortNumbers(p+1, to);
        }
    }
    
    private int partitionNames (int from, int to){
        String pivot = names[from][0];
        int i = from -1;
        int j = to + 1;
        while (i < j ){
            i++; while (names[i][0].compareTo(pivot) < 0) i++;
            j--; while (names[j][0].compareTo(pivot) > 0) j--;
            if (i < j ) swap(i, j);
        }
        return j;
    }
    
    private int partitionNumbers (int from, int to){
        String pivot = names[from][1];
        int i = from -1;
        int j = to + 1;
        while (i < j ){
            i++; while (names[i][1].compareTo(pivot) < 0) i++;
            j--; while (names[j][1].compareTo(pivot) > 0) j--;
            if (i < j ) swap(i, j);
        }
        return j;
    }
    
    private void swap (int i, int j){
        
        String tempName = names[i][0];
        names[i][0] = names[j][0];
        names[j][0] = tempName;
        
        String tempNumber = names[i][1];
        names[i][1] = names[j][1];
        names[j][1] = tempNumber;
    }
    
    private int searchName (String key) {
        int low = 0;
        int high = names.length - 1;
        int mid = 0;
        while ( low <= high){
            mid = (low + high)/2;
            int diff = names[mid][0].compareTo(key);
            
            if (diff == 0 )
                return mid;
            else if (diff < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return -mid;
    }
    
    private int searchNumber (String key) {
        int low = 0;
        int high = names.length - 1;
        int mid = 0;
        while ( low <= high){
            mid = (low + high)/2;
            int diff = names[mid][1].compareTo(key);
            
            if (diff == 0 )
                return mid;
            else if (diff < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return -mid;
    }
    
    public String lookUpName(String number){
        sortNumbers(0, names.length -1);
        numberSorted = true;
        int index = searchNumber(number);
        if (index >= 0)
            return (names[index][0]+ names[index][1]);
        
        //check surrounding entries that for containing search term.
        for (int i = -5; i < 5; i++){
            if (names[index + i][1].contains(number))
                return (names[index + i][0]+ names[index + i][1]);
        }
        
        return "Entry not found.";
    }
    
    public String lookUpNumber(String name){
        sortNames(0, names.length -1);
        nameSorted = true;
        int index = searchName(name);
        if (index >= 0)
            return (names[index][0]+ names[index][1]);
        
        //check surrounding entries that for containing search term.
        for (int i = -5; i < 5; i++){
            if (names[-index + i][0].contains(name))
                return (names[-index + i][0]+ names[-index + i][1]);
        }
        
        return "Entry not found.";
        
        
    }
    
    public void printArray(){
        for(String[] e : names) {
            System.out.println(e[0] + e[1]);
        }
    
            
    }
    private String[][] names = new String[1000][2];
    private boolean numberSorted = false;
    private boolean nameSorted = false;
}
