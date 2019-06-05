import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedOutputStream;

import javax.swing.*;


public class Sender extends Thread {
    JPanel panel;
    JButton send;
    JTextArea text;

    DataOutputStream sender_data_out;
    public Sender(PipedOutputStream sender_output) {
        sender_data_out = new DataOutputStream(sender_output);
        window();

    }
//    public void run(){
//
//        try {
//            sender_data_out.writeChars("test");
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
    public void window() {
        panel = new JPanel();
        JFrame input = new JFrame("Input");
        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setSize(500, 500);
        input.setLocation(700, 500);
        input.getContentPane().add(panel);

        send =  new JButton("Send");
        panel.add(send);
//        send.addActionListener(this);

//        refresh.addActionListener(refreshListener) ;


        String you = " \n  WRITE YOUR MESSAGE HERE : \n";
        JLabel label = new JLabel(you);
        panel.add(label);

        text = new JTextArea(50,50);
        panel.add(text);
        input.setVisible(true);

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        //run();
//        System.out.println("Action performed send ");
//        try {
//            System.out.println(text.getText());
//            sender_data_out.writeUTF(text.getText()+"\n");
//            sender_data_out.flush();
//
//        } catch (Exception e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//
//    }

}