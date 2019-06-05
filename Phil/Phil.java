package session3;
import java.util.concurrent.Semaphore;
public class Phil extends Thread {
	int id;
	Semaphore left;
	Semaphore right;
	public Phil(int id, Semaphore left, Semaphore right) {
		super();
		this.id = id;
		this.left = left;
		this.right = right;
	}
	public void run(){
		while(true){
			try {
				long rand = 100*(long)Math.random();
				System.out.println("phil "+this.id+" is thinking");
				this.sleep(rand);
				System.out.println("phil "+this.id+" picked right");
				right.acquire();
				System.out.println("phil "+this.id+" picked left");
				left.acquire();
				
				System.out.println("phil "+this.id+" is eating");
				this.sleep(rand);
				right.release();
				left.release();
			} catch (Exception e) {
				System.out.println("DeadLock!");
			}
		}
	}
	

}
