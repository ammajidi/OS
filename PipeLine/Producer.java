import java.io.*;
import javax.swing.*;
import java.awt.*;


public class Producer extends Thread{
	DataOutputStream os;

    JFrame window;
    TextField inField;
    Button send ;
    public Producer(OutputStream os){
        //Making UI
        window=new JFrame();
        window.setLayout(new FlowLayout());

        Label label= new Label("Type here :");
        inField = new TextField(20);
        inField.setBackground(new Color(193, 193, 193, 255));
        inField.setPreferredSize(new Dimension(300,300));


        label.setLocation(50,10);

        label.setPreferredSize(new Dimension(100,40));
        send=new Button("Send");
        send.setBackground(new Color(128, 251, 126));
//        send.addActionListener(this);


        window.add(label);
        window.add(inField);
        window.add(send);

        window.setTitle("Sender Side");
        window.setSize(500,250);
        window.setVisible(true);
        //End of UI
    	this.os=new DataOutputStream(os);
    }
	@Override
	public void run() {
		while(true) {
			try {
				os.writeDouble((Math.random()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
