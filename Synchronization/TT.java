
public class TT extends Thread{
	
	int AccID;
	int balance;
	Bank bank;
	
	public TT(int id,int bal,Bank bank) {
		this.AccID=id;
		this.balance=bal;
		this.bank=bank;
		
		
	}
	@Override
	public void run() {
		while(true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bank.transfer(this.AccID, randAcc(),randMoney());
//			Bank.test();
			
		}
		// TODO Auto-generated method stub
		
	}
	public int randAcc() {
		int rand=(int)(Math.random()*10);
		if(rand==10)
			rand=9;
		return rand;
	};
	public int randMoney(){
		int rand=(int)(Math.random()*10000);
		return rand;
	}

}
