import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {

		PipedInputStream consumerIn   = new PipedInputStream();
		PipedOutputStream producerOut = new PipedOutputStream(consumerIn);
		Producer producer = new Producer(producerOut);
		ProducerUI pUI=new ProducerUI(producer);
		ConsumerUI cUI=new ConsumerUI();

		Consumer consumer = new Consumer(consumerIn,cUI);
		producer.start();
		consumer.start();

	}

}
