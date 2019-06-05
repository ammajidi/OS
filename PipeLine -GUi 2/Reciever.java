import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class Reciever extends Thread  {
    DataInputStream reciever_input;
    JRadioButton recieveButton;
    JRadioButton doNotRecieveButton;
    JPanel panel;
    JButton refresh;
    JTextArea text;
    static String buffer="";

    public Reciever(PipedInputStream sender_output) {
        reciever_input = new DataInputStream(sender_output);
        window();
    }
    public void window() {
        JFrame Output = new JFrame("Output");
        panel = new JPanel();

        Output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Output.setSize(500, 500);
        Output.setLocation(100,500);
        Output.getContentPane().add(panel);
        refresh =  new JButton("Refresh");
        panel.add(refresh);

        recieveButton = new JRadioButton("Recieve     \n");
        doNotRecieveButton = new JRadioButton("Do Not Recieve \n");

        ButtonGroup group = new ButtonGroup();
        group.add(recieveButton);
        group.add(doNotRecieveButton);
        panel.add(recieveButton);
        panel.add(doNotRecieveButton);


//        refresh.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//
//                    String msg ;
//               System.out.println("buffer is"+buffer);
//
//                    buffer+= reciever_input.readUTF();
//                    if (doNotRecieveButton.isSelected()){
//                        msg = "";
//
////                    System.out.println("buffer is"+buffer);
//                    }
//                    else if (recieveButton.isSelected()){
//
////                    System.out.println("buffer is"+buffer);
//                        msg=buffer;
//                        buffer="";
//                    }
//                    else {
////                    text.setText("");
//                        msg = "choose button";
//                    }
//                    text.insert(msg,0);
//                }catch (IOException e1) {
//                    System.out.println("waiting for initiation from sender");
//                }
//            }
//        });



        String you = " \n  HERE IS YOUR MESSAGE : \n";
        JLabel label = new JLabel(you);
        panel.add(label);

        text = new JTextArea(50,50);
        panel.add(text);
        Output.setVisible(true);





    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//
////        if(doNotRecieveButton.isSelected()) {
////            System.out.println("Do Not Recieve is On");
////
////
////        }
////        else {
//////            System.out.println("Recieving");
//////            try {
//////                text.insert(reciever_input.readUTF()+"\n",0);
//////
//////            } catch (IOException e2) {
//////                // TODO Auto-generated catch block
//////                e2.printStackTrace();
//////            }
//            try {
//
//                String msg="" ;
//                if (recieveButton.isSelected()){
//                    while (reciever_input.readUTF()!=null) {
////                        System.out.println("test");
//                        buffer += reciever_input.readUTF();
//                        msg = buffer;
//                        buffer = "";
//                    }
//                }
//                else {
//
//                    msg = "";
//                }
//                text.insert(msg,0);
//            }catch (IOException e1) {
//                e1.printStackTrace();
//            }
//
//
//        }

////////////////////////////////////////
//    public void run() {
//        String buffer="";
//        while(true){
//
//            try {
//
//                String msg ;
//                buffer+= reciever_input.readUTF();
//                if (doNotRecieveButton.isSelected()){
//                    msg = "";
////                    System.out.println("buffer is"+buffer);
//                }
//                else if (recieveButton.isSelected()){
////                    System.out.println("bu"+buffer);
//                    buffer+= reciever_input.readUTF();
////                    System.out.println("buffer is"+buffer);
//                    msg=buffer;
//                    buffer="";
//                }
//                else {
////                    text.setText("");
//                    msg = "choose button";
//                }
//                text.insert(msg,0);
//            }catch (IOException e) {
//                System.out.println("waiting for initiation from sender");
//            }
//        }
//    }
}
