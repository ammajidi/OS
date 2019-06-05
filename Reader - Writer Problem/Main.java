import java.util.Vector;
public class Main {
    public static void mainMethod(){
        Board BBoard = new Board();
        Vector<String> words1 = new Vector<String>();
        words1.add("I ");
        words1.add("Am ");
        words1.add("Writer 1");
        Vector<String> words2 = new Vector<String>();
        words2.add("This");
        words2.add("Is");
        words2.add("Writer 2");
        Thread writer1 = new Thread(new Writer(BBoard,words1));
        Thread writer2 = new Thread(new Writer(BBoard,words2));
        Thread reader = new Thread(new Reader(BBoard));
        writer1.start();
        writer2.start();
        reader.start();
    }
    public static void main(String[] args) {
        mainMethod();

    }
}
