

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        try {

            PipedOutputStream sender_output= new PipedOutputStream();
            PipedInputStream reciever_input = new PipedInputStream(sender_output);
            Reciever reciever = new Reciever(reciever_input);
            Sender sender = new Sender(sender_output);
            reciever.start();
            sender.start();



            sender.send.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //run();
                    System.out.println("Action performed send ");
                    try {
                        System.out.println(sender.text.getText());
                        sender.sender_data_out.writeUTF(sender.text.getText()+"\n");
                        sender.sender_data_out.flush();
///////////////////////////////
                    String msg ;
               System.out.println("buffer is"+reciever.buffer);

                    reciever.buffer+= reciever.reciever_input.readUTF();
                    if (reciever.doNotRecieveButton.isSelected()){
                        msg = "";

//                    System.out.println("buffer is"+buffer);
                    }
                    else if (reciever.recieveButton.isSelected()){

//                    System.out.println("buffer is"+buffer);
                        msg=reciever.buffer;
                        reciever.buffer="";
                    }
                    else {
//                    text.setText("");
                        msg = "choose a mode\n";
                    }
                        reciever.text.insert(msg,0);

                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
            });

            reciever.refresh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //run();
                    System.out.println("Action performed refresh ");
                    try {
                        System.out.println(sender.text.getText());
                        sender.sender_data_out.writeUTF("");
                        sender.sender_data_out.flush();

///////////////////////////////
                        String msg ;
                        System.out.println("buffer is"+reciever.buffer);

                        reciever.buffer+= reciever.reciever_input.readUTF();
                        if (reciever.doNotRecieveButton.isSelected()){
                            msg = "";

//                    System.out.println("buffer is"+buffer);
                        }
                        else if (reciever.recieveButton.isSelected()){

//                    System.out.println("buffer is"+buffer);
                            msg=reciever.buffer;
                            reciever.buffer="";
                        }
                        else {
//                    text.setText("");
                            msg = "choose a mode \n";

                        }
                        reciever.text.setText("--Refreshed--");
                        reciever.text.insert(msg,0);

                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
            });

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
