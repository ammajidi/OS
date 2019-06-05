import java.net.MalformedURLException;
import java.rmi.*;
public class Client {
	int id;
	public Client(int id) {
		this.id=id;
	}
	public void order(String p1,int amount) {
		try {
			String url= "rmi://localhost/";
			Product pizza =(Product)Naming.lookup(url+p1);
			pizza.setAmount(amount);
//			Product coke =(Product)Naming.lookup(url+p2);
//			coke.setAmount(3);
//			Product sauce =(Product)Naming.lookup(url+p3);
//			sauce.setAmount(4);
			
			
			System.out.println("Client"+this.id +" "+pizza.getDescription());
//			System.out.println(this.id +" "+coke.getDescription());
//			System.out.println(this.id +" "+sauce.getDescription());
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
//	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
//		// TODO Auto-generated method stub
//
//		
//		try {
//			String url= "rmi://localhost/";
//			Product pizza =(Product)Naming.lookup(url+"order1");
//			pizza.setAmount(2);
//			Product coke =(Product)Naming.lookup(url+"order2");
//			coke.setAmount(3);
//			Product sauce =(Product)Naming.lookup(url+"order3");
//			sauce.setAmount(4);
//			
//			
//			System.out.println(pizza.getDescription());
//			System.out.println(coke.getDescription());
//			System.out.println(sauce.getDescription());
//			
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}

}
