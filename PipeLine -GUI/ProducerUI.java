import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProducerUI extends JFrame implements ActionListener {

    TextField inField;
    Button send ;
    Producer producer;
    public ProducerUI(Producer producer){
        setLayout(new FlowLayout());
        Label label= new Label("Type here :");
        inField = new TextField(20);
        inField.setBackground(new Color(193, 193, 193, 255));
        inField.setPreferredSize(new Dimension(300,300));


        label.setLocation(50,10);

        label.setPreferredSize(new Dimension(100,40));
        send=new Button("Send");
        send.setBackground(new Color(128, 251, 126));
        send.addActionListener(this);


        add(label);
        add(inField);
        add(send);

        setTitle("Sender Side");
        setSize(500,250);
        setVisible(true);
        this.producer=producer;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            System.out.println("send pressed : "+inField.getText());
            producer.os.writeUTF(inField.getText()+"\n");
            producer.os.flush();
//            producer.ui.inField.setText(" ");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
