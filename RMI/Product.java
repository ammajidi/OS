import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote{
	public String getDescription() throws RemoteException;
	public void setAmount(int amount)throws RemoteException;
	public int getAmount()throws RemoteException;
}
