
public class Reader implements Runnable{
    Board BBoard;
    public Reader(Board b){

        this.BBoard=b;
    }
    public void run(){
        while(true){
            System.out.println("Board = "+BBoard.readFromBoard());
            try {
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
