import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.awt.*;


public class Producer extends Thread{
    DataOutputStream os;
    ProducerUI ui;
    public Producer(OutputStream os){
        this.os=new DataOutputStream(os);
    }


}
