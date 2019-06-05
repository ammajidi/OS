import java.util.Vector;

public class Writer implements Runnable {
    Vector<String> words ;
    Board BBoard;
    public Writer(Board b,Vector<String> w){
        this.words=w;
        this.BBoard=b;
    }
    public void run(){
        int size=0;
        while (true){
            if(size==3){
                size=0;
                BBoard.clearTheBoard();
            }
            BBoard.writeOnBoard(words.elementAt(size));
            size++;
            try {
                Thread.sleep(100);


            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
