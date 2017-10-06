
package messagingsimulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that simulates an email server by controlling user logins, reading and
 * sending messages and maintaining the state of a user's session.
 * @author torre
 */
public class MailServer {
    
    /**
     * Creates a mail server from stored UserList file.
     */
    public MailServer(){
        state = LOGIN;
    }
    
    /**
     * Logs current user out and returns MailServer to initial state.
     */
    public void reset(){
        user = null;
        state = LOGIN;
    }
    
    /**
     * Returns state to "logged in" status from Read or Send status.
     */
    public void back (){
        if(state == READING || state == SENDING){
            state = LOGGEDIN;
        }
    }
    
    /**
     * Returns the current state of the MailServer.
     * @return 
     */
    public int getState(){
        return state;
    }
    
    /**
     * Attempts to sign in a user given the user supplied credentials.
     * @param aUserName name of user being signed in
     * @param aPassword password of user attempting to login
     * @return String that indicates whether log in was successful or not.
     */
    public String loginUser(String aUserName, String aPassword){
        
        boolean loggedIn = false;
        try {
            FileReader file = new FileReader("UserLogins.txt");
            Scanner in = new Scanner(file);
            
            while (in.hasNextLine()){
                Scanner currentLine = new Scanner(in.nextLine()).useDelimiter("/");
                if (currentLine.next().equalsIgnoreCase(aUserName))
                        if (currentLine.next().equals(aPassword)){
                            user = new User(aUserName.toLowerCase());
                            loggedIn = true;
                            state = LOGGEDIN;
                        }
            }
            
            in.close();
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(MailServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MailServer.class.getName()).log(Level.SEVERE, null, ex);
            return "User Credential File Not Found.  Please Contact Administrator.";
        }
       
        if (loggedIn == true)
            return "Login Successful";
        else
            return "Login Failed. Incorrect username/password.";
        
    }
    
    /**
     * Calls the currently enumerated message from the mailbox for viewing.
     * @return returns message as a readable string.
     */
    public String readMessage(){
        if(user.getMessageCount() == 0)
            return "Mailbox is empty.";
        else
            return user.getMessage(messageNumber).toReadableString();
    }
    
    public String previousMessage(){
        if (messageNumber > 0){
            messageNumber--;
            return readMessage();
        }
        else
            return "There are no previous messages.";
    }
    
    public String nextMessage(){
        if (user.getMessageCount() <= messageNumber + 1)
            return "There are no more messages to read.";
        else{
            messageNumber++;
            return readMessage();
        }
            
    }
    
    /**
     * Deletes the currently enumerated message from the mailbox.
     */
    public String deleteMessage(){
        if (user.getMessageCount() == 0) {
            return "Mailbox is empty.  Messages cannot be deleted.";
        }
        
        user.deleteMessage(messageNumber);
        
        if (messageNumber >= user.getMessageCount())
            messageNumber = user.getMessageCount() - 1;
        return readMessage();
    }
    
    /**
     * Sends a message from the currently logged in user.
     */
    public void sendMessage(String aRecipient, String contents){
        user.sendMessage(aRecipient, contents);
        back();
    }
    
    public void setStateToSending(){
        state = SENDING;
    }
    
    /**
     * Opens a mailbox for the currently logged in user.
     * @param boxType server.SENT or server.RECIEVED 
     */
    public void openMailbox(int boxType) {
        if (boxType == RECIEVED)
            user.openMailbox("Recieved");
        else
            user.openMailbox("Sent");
        state = READING;
        messageNumber = 0;
    }
    
    public void closeMailbox(){
        user.closeMailbox();
        back();
    }
    
    private int messageNumber;
    
    public final static int LOGIN = 1;
    public final static int LOGGEDIN = 2;
    public final static int READING = 3;
    public final static int SENDING = 4;
    
    public final static int RECIEVED = 1;
    public final static int SENT = 2;
    
    private int state;
    private User user;
    
    
}
