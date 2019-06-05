import java.util.Date;

class Producer implements Runnable{

    private  BoundedBuffer buffer;

    public Producer(BoundedBuffer b) {
        buffer = b;
    }

    public void run(){
        Date message;
        while (true) {
//            System.out.println("Producer napping");
//            SleepUtilities.nap();
            // produce an item & enter it into the buffer
            message = new Date();
            System.out.println("Producer produced \"" + message + "\"");
            buffer.insert(message);
        }
    }
}