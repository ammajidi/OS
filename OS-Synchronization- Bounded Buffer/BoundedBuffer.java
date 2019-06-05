
import java.util.concurrent.Semaphore;

class BoundedBuffer {

    private static int BUFFER_SIZE = 3;
    private int count; //tedadi ke tooye buffer e
    private int in;   // points to the next free position in the buffer
    private int out;  // points to the first filled position in the buffer
    private Object[] buffer; //array of Objects
    private Semaphore mutex; //mutual exclusion
    private Semaphore empty;
    private Semaphore full;

    public BoundedBuffer(){
        //empty
        count = 0;
        in = 0;
        out = 0;
        buffer = new Object[BUFFER_SIZE];
        mutex = new Semaphore(1); //1 for mutual exclusion
        empty = new Semaphore(BUFFER_SIZE); //array begins with all empty elements
        full = new Semaphore(0); //array begins with no elements
    }


    public void insert(Object item) {

        try{
            empty.acquire(); //wait
            mutex.acquire(); //mutual exclusion
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        count++;
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        if (count == BUFFER_SIZE){
            System.out.println("BUFFER FULL ");
//                    + "Producer inserted \"" + item
//                    + "\" count=" + count + ", "
//                    + "in=" + in + ", out=" + out);
        }
        else{
            System.out.println("Producer inserted \"" + item
                    + "\" count=" + count + ", "
                    + "in=" + in + ", out=" + out);
        }

        mutex.release(); //mutual exclusion
        full.release(); //signal
        //If buffer was empty, then this wakes up the Consumer
    }

    public Object remove() {
        Object item=null;
        try{
            full.acquire(); //wait
            mutex.acquire(); //mutual exclusion
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        count--;
        item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        if (count == 0){
            System.out.println("BUFFER EMPTY ");
//                    + "Consumer removed \"" + item
//                    + "\" count=" + count + ", "
//                    + "in=" + in + ", out=" + out);
        }
        else{
            System.out.println("Consumer removed \"" + item
                    + "\" count=" + count + ", "
                    + "in=" + in + ", out=" + out);
        }

        mutex.release(); //mutual exclusion
        empty.release(); //signal
        //if buffer was full, then this wakes up the Producer
        return item;
    }
    public static void main(String args[]) {
        BoundedBuffer buffer = new BoundedBuffer();
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }

}

