
public class Bank {
	static int transactionCounts;
	static TT[] accounts;
	public Bank() {
		accounts=new TT[10];
		transactionCounts=0;
		for (int i=0;i<10;i++) { 
			accounts[i]=new TT(i, 10000,this);
		}
		
		
	}
	synchronized public  void transfer(int src,int dis,int value) {
		TT source=accounts[src];
		TT distination=accounts[dis];
		if(source.balance<value) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		source.balance-=value;
		distination.balance+=value;
		transactionCounts++;
		notifyAll();
		test();
		
	}
	public static void test() {
		int sum=0;
		for (int i=0;i<10;i++) {
			sum+=accounts[i].balance;
		}
		System.out.println("transaction No : "+transactionCounts+" |Sum is :"+sum);
	}
}
