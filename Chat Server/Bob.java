import java.net.*;
import java.io.*;
class Bob{
	public static void main(String args[])throws Exception{
		Socket socket=new Socket("localhost",3335);
		DataInputStream is=new DataInputStream(socket.getInputStream());
		DataOutputStream os=new DataOutputStream(socket.getOutputStream());

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String sentMsg="",recievedMsg="";
		while(!sentMsg.contains("bye")){
			sentMsg=br.readLine();
			os.writeUTF(sentMsg);
			os.flush();
			recievedMsg=is.readUTF();
			System.out.println("- Amir : "+recievedMsg);
		}

		os.close();
		socket.close();
	}}