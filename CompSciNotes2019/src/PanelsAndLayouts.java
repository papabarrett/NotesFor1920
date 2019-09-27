/**
 *
 * @author J. Barrett
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.*;
import javax.swing.*;

public class PanelsAndLayouts {
    public static void main(String[] args) throws Exception {
        new PanelsAndLayouts();
    }
    JFrame frame;
    JButton submit;
    JLabel title, nameLabel, dobLabel, emailLabel;
    JTextField nameField, dobField, emailField;
    JTextArea essayArea;
    JPanel fieldPanel;
    
    public PanelsAndLayouts(){
        frame=new JFrame("College Application Window");
        frame.setLayout(new BorderLayout());
        fieldPanel=new JPanel(new GridLayout(0,2));
        frame.add(fieldPanel,BorderLayout.WEST);
        submit=new JButton("Submit");
        frame.add(submit,BorderLayout.SOUTH);
        essayArea=new JTextArea("Write your essay here...");
        essayArea.setPreferredSize(new Dimension(200,400));
        frame.add(essayArea,BorderLayout.CENTER);
        title=new JLabel("College Application");
        frame.add(title,BorderLayout.NORTH);
        for (int i = 0; i < 8; i++) {
            fieldPanel.add(new JLabel());
        }
        nameLabel=new JLabel("Name");
        fieldPanel.add(nameLabel);
        nameField=new JTextField();
        fieldPanel.add(nameField);
        fieldPanel.add(new JLabel("Email"));
        emailField=new JTextField();
        fieldPanel.add(emailField);
        fieldPanel.add(new JLabel("Date of Birth"));
        dobField=new JTextField();
        fieldPanel.add(dobField);
        for (int i = 0; i < 9; i++) {
            fieldPanel.add(new JLabel());
        }
        
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

}