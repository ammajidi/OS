import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		PipedInputStream filterIn     =   new PipedInputStream();
		PipedOutputStream filterOut   = new PipedOutputStream();
		PipedInputStream consumerIn   = new PipedInputStream(filterOut);
		PipedOutputStream producerOut = new PipedOutputStream(filterIn);
		Filter filter=new Filter(filterIn, filterOut);
		Producer producer = new Producer(producerOut);
		Consumer consumer = new Consumer(consumerIn);
		producer.start();
		filter.start();
		consumer.start();
		
	}

}
