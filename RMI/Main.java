import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Server server = new Server();
		Client c1= new Client(1);
		Client c2= new Client(2);
		Client c3= new Client(3);
		Scanner s=new Scanner(System.in);
		c1.order("order1", s.nextInt());
		c2.order("order2", s.nextInt());
		c3.order("order3", s.nextInt());
		
		

	}

}
