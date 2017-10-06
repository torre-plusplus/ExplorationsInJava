
package messagingsimulator;

import java.util.Scanner;

/**
 * Program that creates a user authenticated messaging system, similar to
 * email.
 * @author torre
 */
public class MessagingSimulator {

    public static void main(String[] args) {
        System.out.println("Welcome to 198x Communo-link Software");
        System.out.println("Current Users: Nibbler/dog\n" +
            "Torre/norton\n" +
            "Kelsey/brown\n" +
            "Travis/norton");
        
        MailServer server = new MailServer();
        
        boolean done = false;
        Scanner in = new Scanner(System.in);
        while (!done){
            
            //log in user and provide option to exit
            if (server.getState() == server.LOGIN){
                System.out.println("Please enter username (-1 to shutdown): ");
                String userName = in.next();
                
                if (userName.equals("-1"))
                    done = true;
                else{

                    System.out.println("Please enter password: ");
                    String password = in.next();

                    System.out.println(server.loginUser(userName, password));
                }
            }
            
            //provide options of reading or sending messages
            else if (server.getState() == server.LOGGEDIN){
                System.out.println("Please the number of desired option:"
                        + "\n1. Read\\Delete Messages \n2.  Send Email"
                        + "\n3. Logout \n4. Shutdown");
                String userOption = in.next();
                
                if (userOption.contains("1")){
                    System.out.println("Please enter which mailbox to open: "
                    + "\n1. Recieved Messages \n2. Sent Messages");
                    String boxOption = in.next();
                    if(boxOption.contains("1"))
                        server.openMailbox(server.RECIEVED);
                    else if (boxOption.contains("2"))
                        server.openMailbox(server.SENT);
                    else
                        System.out.println("Input not recognized.");
                }
                else if (userOption.contains("2")){
                    server.setStateToSending();
                }
                else if (userOption.contains("3")){
                    server.reset();
                }
                else if (userOption.contains("4")){
                    done = true;
                }
                else
                    System.out.println("Input not recognized.");
            }
            
            //prompts user for mailbox to open (sent or recieved)
            // allows for reading and deleting of emails
            //closes mailbox and calls back function
            else if (server.getState() == server.READING){
                boolean stillReading = true;
                System.out.println(server.readMessage());
                
                while(stillReading){
                    System.out.println("Enter action to take: "
                            + "\n1. Next Message \n2. Previous Message"
                            + "\n3. Delete Message \n4. Close Mailbox");
                    String userOption = in.next();
                    if(userOption.contains("1"))
                        System.out.println(server.nextMessage());
                    else if (userOption.contains("2"))
                        System.out.println(server.previousMessage());
                    else if (userOption.contains("3"))
                        System.out.println(server.deleteMessage());
                    else if (userOption.contains("4")){
                        server.closeMailbox();
                        server.back();
                        stillReading = false;
                    }
                }
            }
            
            //prompts user for message to send and recipient.
            //calls send function and ask user if they'd like to 
            //send another.  Calls back function.
            else if (server.getState() == server.SENDING){
                boolean stillSending = true;
                while (stillSending){
                    Scanner sendIn = new Scanner(System.in).useDelimiter("\n");
                    System.out.println("Please enter a message recipient: ");
                    String recipient = sendIn.next();
                    //in.nextLine();
                    System.out.println("Please enter message contents: ");                    
                    String contents = sendIn.next();
                    server.sendMessage(recipient, contents);
                    System.out.println("Message sent.  Would you like to send"
                            + " another? \n1. Yes \n2. No");
                    String anotherMessage = in.next();
                    in.nextLine();
                    if (anotherMessage.contains("2"))
                        stillSending = false;
                }
            }
        }
        
    }
    
}
