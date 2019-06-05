//import java.net.MalformedURLException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList; 
public class Server   {
//	static ArrayList <Order> orders = new ArrayList<>();
	public Server() {
		try {
			ProductImplementation pizza = new ProductImplementation("Pizza",0);
			ProductImplementation coke = new ProductImplementation("Coke",0);
			ProductImplementation sauce = new ProductImplementation("Sauce ",0);
	//		Order order1=new OrderImplementation("Pizza", 4);
	//		Order order2=new OrderImplementation("Coke", 1);
	//		Order order3=new OrderImplementation("Sauce", 3);
			Naming.rebind("order1", pizza);
			Naming.rebind("order2", coke);
			Naming.rebind("order3", sauce);
	
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// TODO Auto-generated method stub
		
		
		
	}

}
