import java.io.*;
import java.net.*;
public class Server {
	static ServerSocket ss1;
	static ServerSocket ss2;

	static DataInputStream isAmir;
	static DataOutputStream osAmir;

	static DataInputStream isBob;
	static DataOutputStream osBob;

	static boolean openAmir;
	static boolean openBob;

	public static void main(String[]args) throws Exception{
//		String outAmir;
//		String outBob;
		String inBob="";
		String inAmir="";

		openAmir=true;
		openBob=true;

		try {
			ss1=new ServerSocket(3334);
			ss2=new ServerSocket(3335);
			Socket socketAmir=ss1.accept();
			Socket socketBob=ss2.accept();
			isAmir=new DataInputStream(socketAmir.getInputStream());
			isBob=new DataInputStream(socketBob.getInputStream());
			osBob=new DataOutputStream(socketBob.getOutputStream());
			osAmir=new DataOutputStream(socketAmir.getOutputStream());

			while(!inAmir.contains("bye")||!inBob.contains("bye")) {
				System.out.println("Server is running");
				if((inBob = isBob.readUTF()) != null)
				{
					System.out.println("-S : from Bob"+inBob);
				}
				if((inAmir = isAmir.readUTF()) != null)
				{
					System.out.println("-S : from Amir"+inAmir);
				}
//				System.out.println("Server is ON1");
				osAmir.writeUTF(inBob);
				osAmir.flush();
				osBob.writeUTF(inAmir);
				osBob.flush();
//				System.out.println("open status : "+ open);

			}
//			socket.close();





		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}