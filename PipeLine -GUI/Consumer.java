import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Consumer extends Thread {
    DataInputStream is;
    ConsumerUI ui;

    public Consumer(InputStream is,ConsumerUI ui){
        this.ui=ui;
        this.is= new DataInputStream(is);
    }




    @Override
    public void run() {
        String buffer="";
        while(true){

                try {

                    String msg ;
                    if (ui.receiveButton.isSelected()){
                         System.out.println("test");
                        buffer+= is.readUTF();
                         msg=buffer;
                         buffer="";

                    }
                    else {

                        msg = "";
                    }
                    ui.outField.insert(msg,0);
                }catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            }
    }



