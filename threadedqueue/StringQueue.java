
package threadedqueue;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class that maintains a string of queues to print.
 * @author torre
 */
public class StringQueue {
    
    public StringQueue () {
        queue = new ArrayList<>();
    }
    
    public synchronized void generate() throws InterruptedException{
        
        for (int i = 0; i <= 99; i++){
            if (queue.size() > 9) {
                wait();
                
            }
            
            Date now = new Date();
            queue.add(now);
            notifyAll();
                
        }
    }
    
    public synchronized void print() throws InterruptedException {
        for (int i = 0; i <= 99; i++) {
            
            
            if (queue.isEmpty()) {
                notifyAll();
                wait();
            }
            
            System.out.println(queue.remove(0) + " i = " + i);
            
        }
    }
    
    
    
    private ArrayList<Date> queue;
}
