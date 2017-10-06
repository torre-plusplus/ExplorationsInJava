
package messagingsimulator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User class that manages both sent and received
 * mailboxes, as well as sending messages.
 * @author torre
 */
public class User {
    
    /**
     * Creates a user after login has authenticated credentials.
     * @param aUser 
     */
    public User(String aUser){
        userName = aUser;
    }
    
    /**
     * Returns the name of currently logged in user.
     * @return 
     */
    public String getName(){
        return userName;
    }
    
    /**
     * Opens one of the user's mailboxes and stores it as an asset.
     * @param boxType 
     */
    public void openMailbox(String boxType) {
        openBox = new Mailbox(userName, boxType);
    }
    
    /**
     * Calls the close function for the open mailbox, saving all changes to 
     * the mailbox to disc.
     */
    public void closeMailbox () {
        openBox.closeMailbox();
    }
    
    /**
     *  Returns requested message from the open mailbox.
     * @param messageRequested
     * @return 
     */
    public Message getMessage(int messageRequested){
        return openBox.readMessage(messageRequested);
    }
    
    public int getMessageCount(){
        return openBox.getMessageCount();
    }
    
    public void deleteMessage(int messageNumber){
        openBox.deleteMessage(messageNumber);
    }
    
    /**
     * Sends a message to another user's mailbox from this user.  Also saves
     * a copy of the message to this user's sent mailbox.
     * @param aRecipient
     * @param contents 
     */
    public void sendMessage(String aRecipient, String contents){
        //pulls current time stamp and converts to string
        long currentMillis = System.currentTimeMillis();
        Date date = new Date(currentMillis);
        SimpleDateFormat form = new SimpleDateFormat("MMM.dd.yyyy");
        String timeStamp = form.format(date);
        
        Message message = new Message(aRecipient, userName, timeStamp, contents);
        
        FileWriter file;
        String output = "";
        
        
        //saves to user's sent file.
        try {
            file = new FileWriter(userName + "Sent" + ".txt", true);
            
            output = message.toSaveableString();
            
            file.write(output);
            
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(Mailbox.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //saves to recipient's recieved file
        try {
            file = new FileWriter(message.getRecipient() + "Recieved" + ".txt", true);
            
            file.write(output);
            
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(Mailbox.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    private String userName;
    private Mailbox openBox;
}
