import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProductImplementation extends UnicastRemoteObject implements Product{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int amount;
	

	public ProductImplementation(String name,int amount) throws RemoteException {
		this.name=name;
		this.amount=amount;
		
	}

	@Override
	public String getDescription()  throws RemoteException{
		return "Order details : "+this.amount + " " +this.name;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAmount(int amount) throws RemoteException {
		this.amount=amount;
	}

	@Override
	public int getAmount() throws RemoteException {
		return this.amount;
		
	}

}
