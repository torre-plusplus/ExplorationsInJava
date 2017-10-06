
package messagingsimulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Mailbox that stores and manages messages belonging to specific users.
 * @author torre
 */
public class Mailbox {
    
    /**
     * Loads the mailbox of a user and stores messages as an ArrayList.
     * @param aUser 
     */
    public Mailbox (String aUser, String aBoxType){
        
   
        fileName = aUser + aBoxType;
        FileReader file;
        Scanner in;
        
        try {
            file = new FileReader (fileName + ".txt");
        } catch (FileNotFoundException ex) {
            try {
                PrintWriter writer = new PrintWriter(fileName+ ".txt");
                writer.close();
                file = new FileReader (fileName + ".txt.");
            } catch (IOException ex1) {
                file = null;
            }
            
        }
        
        if (!file.equals(null))
            in = new Scanner (file);
        else
            in = new Scanner ("");
        
        while (in.hasNextLine()){
            
            String currentLine = in.nextLine();
            
            if (!currentLine.equals("")){
               
                Scanner currentIn = new Scanner(currentLine);
                currentIn.useDelimiter("/");
                
                String recipient = currentIn.next();
                String sender = currentIn.next();
                String timeStamp = currentIn.next();

                String content = currentIn.next();


                messages.add(new Message(recipient, sender, timeStamp, content));
                currentIn.close();
            }
        }
        in.close();

        try {
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(Mailbox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Returns selected message for display by UI.
     * @param messageNumber
     * @return 
     */
    public Message readMessage(int messageNumber){
        return messages.get(messageNumber);
        
    }
    
    /**
     * Deletes a specified message from this mailbox.
     * @param messageNumber 
     */
    public void deleteMessage (int messageNumber){
        messages.remove(messageNumber);
        messagesDeleted++;
    }
    
    public int getMessageCount(){
        return messages.size();
    }
        
    
    
    /**
     * Closes mailbox and saves ArrayList to .txt (overwriting previous file.)
     */
    public void closeMailbox () {
        
        PrintWriter file;
        String output = "";
        
        try {
            file = new PrintWriter(fileName + ".txt");
            for (Message message: messages)
                output += message.toSaveableString();
            
            
            //overwriting deleted emails w/ blank space... needs more work...
//            for (int i = 0; i < messagesDeleted; i++){
//                output += "\n\n\n\n\n\n\n\n\n\n\n";
//            }
            
            
            file.print(output);
            
            file.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Mailbox.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    private String fileName;
    private ArrayList<Message> messages = new ArrayList<>();
    private int messagesDeleted = 0;
}
