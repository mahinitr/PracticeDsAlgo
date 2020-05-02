package others;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

//Producer Class in java
class ProducerBQ implements Runnable {

    private final BlockingQueue sharedQueue;

    public ProducerBQ(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++){
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(5000));
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

//Consumer Class in Java
class ConsumerBQ implements Runnable{

    private final BlockingQueue sharedQueue;

    public ConsumerBQ (BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(5000));
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}


public class ProducerConsumerUsingBQ {

    public static void main(String args[]){

        //Creating shared object
        BlockingQueue sharedQueue = new LinkedBlockingQueue(10);

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new ProducerBQ(sharedQueue));
        Thread consThread = new Thread(new ConsumerBQ(sharedQueue));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
    }

}