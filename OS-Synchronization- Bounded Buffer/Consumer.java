import java.util.Date;

class Consumer implements Runnable{

    private BoundedBuffer buffer;

    public Consumer(BoundedBuffer b) {
        buffer = b;
    }

    public void run(){
        Date message = null;
        while (true){
//            System.out.println("Consumer napping");
//            SleepUtilities.nap();
            // consume an item from the buffer
            System.out.println("Consumer wants to consume");
            message = (Date)buffer.remove();
            System.out.println("Consumer  consumed \"" + message + "\"");
        }
    }
}