import java.io.*;


public class Filter extends Thread {
	DataInputStream is;
	DataOutputStream os;
	double sum;
	double counter;
	public Filter(InputStream is,OutputStream os){
		this.is= new DataInputStream(is);
		this.os= new DataOutputStream(os);
		this.sum=0;
		this.counter=0;
	}
	@Override
	public void run() {
		while(true) {
			try {
				counter++;
				double temp=is.readDouble();
				sum+=temp;
				os.writeDouble(sum/counter);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

