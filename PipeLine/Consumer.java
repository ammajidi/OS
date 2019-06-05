import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Consumer extends Thread {
    DataInputStream is;
    JFrame window;
    TextArea outField;
    JRadioButton receiveButton;
    JRadioButton closeButton;
    public Consumer(InputStream is){
        String state="Receiving ... \n" ;


        window=new JFrame();
        window.setLayout(new FlowLayout());

        Label receiverLabel = new Label("Choose Mode :");
        outField = new TextArea();
        outField.setBackground(new Color(193, 193, 193, 255));
        outField.setEditable(false);
        outField.setText(state);
        outField.setPreferredSize(new Dimension(300,300));

        receiveButton =new JRadioButton("Open");
        closeButton =new JRadioButton("Close");

        ButtonGroup group =new ButtonGroup();
        group.add(receiveButton);
        group.add(closeButton);

        receiverLabel.setLocation(50,10);

        receiverLabel.setPreferredSize(new Dimension(100,40));
        receiveButton.setBackground(new Color(128, 251, 126));
        closeButton.setBackground(new Color(251, 113, 100));

        window.add(receiverLabel);
        window.add(receiveButton);
        window.add(closeButton);
        window.add(outField);

        window.setTitle("Receiver Side");
        window.setSize(500,500);
        window.setVisible(true);
	
	
		this.is= new DataInputStream(is);
	}
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Average is :"+is.readDouble());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
