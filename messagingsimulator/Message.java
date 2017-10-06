
package messagingsimulator;

/**
 * Basic class that represents messages that are passed to and from users.
 * @author torre
 */
public class Message {
    
    /**
     * Constructs a message object to be passed to a mailbox.
     * @param aRecipient
     * @param aSender
     * @param aTimeStamp
     * @param aContent 
     */
    public Message (String aRecipient, String aSender, String aTimeStamp, String aContent){
        recipient = aRecipient;
        sender = aSender;
        timeStamp = aTimeStamp;
        contents = aContent;
        
    }
    
    
    /**
     * Returns the message as a string for display.
     * @return Legible form of message.
     */
    public String toReadableString(){
        String readable = "To: " + getRecipient() + "\nFrom: " 
                    + getSender() + "\n" + getTimeStamp() + "\n" 
                    + getContent();
        return readable;
        
    }
    
    /**
     *  Returns message in savable String format of the file structure.
     * @return 
     */
    public String toSaveableString(){
        String saveable = System.lineSeparator() + recipient + "/" 
                    + sender + "/" + timeStamp + "/" 
                    + contents + System.lineSeparator();
        return saveable;
        
    }
    
    /**
     * returns message's recipient
     * @return 
     */
    public String getRecipient(){
        return recipient;
    }
    
    /**
     * returns message's sender
     * @return 
     */
    public String getSender(){
        return sender;
    }
    
    /**
     * returns message's Time Stamp
     * @return 
     */
    public String getTimeStamp(){
        return timeStamp;
    }
    
    /**
     * returns message's contents
     * @return 
     */
    public String getContent(){
        return contents;
    }
    
    private String recipient;
    private String sender;
    private String timeStamp;
    private String contents;
    
}
