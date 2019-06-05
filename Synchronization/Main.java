
public class Main {

	public static void main(String[] args) {
		Bank bank=new Bank();
		for (int i=0;i<10;i++) {
			Bank.accounts[i].start();
		}	
	}

}
