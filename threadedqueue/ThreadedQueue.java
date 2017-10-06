
package threadedqueue;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that starts two synchronized threads to populate a queue of strings and
 * to print the threads waiting in the queue.
 * @author torre
 */
public class ThreadedQueue {

    public static void main(String[] args) {
        
        StringQueue que = new StringQueue();
        class GenerateRunnable implements Runnable {
            public void run(){
                try {
                    que.generate();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadedQueue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        class PrintRunnable implements Runnable{
            public void run() {
                try {
                    que.print();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadedQueue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        Runnable r1 = new GenerateRunnable();
        Runnable r2 = new PrintRunnable();
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        
        t1.start();
        t2.start();
    }
    
    
}
