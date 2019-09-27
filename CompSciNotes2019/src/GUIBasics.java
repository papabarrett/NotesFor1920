/**
 *
 * @author J. Barrett
 */

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.*;

public class GUIBasics {
    public static void main(String[] args) throws Exception {
        new GUIBasics();
    }
    
    JFrame frame;
    JButton button;
    JLabel label, response;
    JTextField field;
    ButtonGroup group;
    JRadioButton upper, lower;
    Font font;
    
    public GUIBasics(){
        frame=new JFrame("Case Changer");
        label=new JLabel("Text: ");
        response=new JLabel("");
        button=new JButton("Translate");
        field=new JTextField("");
        group=new ButtonGroup();
        upper=new JRadioButton("Uppercase");
        lower=new JRadioButton("Lowercase");
        font=new Font("Hobo Std",Font.PLAIN,45);
        label.setFont(font);
        response.setFont(font);
        button.setFont(font);
        field.setFont(font);
        upper.setFont(font);
        lower.setFont(font);
        frame.setLayout(new GridLayout(0,2));
        
        frame.add(label);
        frame.add(field);
        frame.add(upper);
        frame.add(lower);
        frame.add(button);
        frame.add(response);
        
        group.add(lower);
        group.add(upper);
        upper.setSelected(true);
        
        button.addActionListener(new Listener());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    class Listener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(upper.isSelected()){
                response.setText(field.getText().toUpperCase());
            }
            else if(lower.isSelected()){
                response.setText(field.getText().toLowerCase());
            }
            else
                response.setText("Please Select a Case");
            frame.pack();

        }
        
    }

}