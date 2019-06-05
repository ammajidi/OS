import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class ConsumerUI extends JFrame  {

    TextArea outField;
    JRadioButton receiveButton;
    JRadioButton closeButton;
    public ConsumerUI(){
        String state="Receiving ... \n" ;
        setLayout(new FlowLayout());
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
        add(receiverLabel);
        add(receiveButton);
        add(closeButton);
        add(outField);

        setTitle("Receiver Side");
        setSize(500,500);
        setVisible(true);


    }


}
