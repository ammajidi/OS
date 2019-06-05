package session3;
import java.util.Vector;
import java.util.concurrent.Semaphore;
public class Main {

	public static void main(String[]args){
		Vector<Semaphore> forks = new Vector<>();
		Vector<Phil> phils = new Vector<>();
		for(int i=0;i<5;i++){
			forks.add(new Semaphore(1));
		}for(int i=0;i<5;i++){
			phils.add(new Phil(i, forks.get(i),forks.get((i+1)%5)));
		}
		for(int i=0;i<5;i++){
			phils.get(i).start();
		}
		
	
	}
}
