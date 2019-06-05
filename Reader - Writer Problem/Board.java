public class Board {
    String BBoard="";
    public String readFromBoard(){

        return BBoard;

    }
    public void writeOnBoard(String s){

        BBoard += s;

    }

    public void clearTheBoard(){

        BBoard="";

    }
}


