/**
 *
 * @author J. Barrett
 */

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GolfGUI {
    public static void main(String[] args) throws Exception {
        new GolfGUI();
    }
    JFrame frame;
    JTextField[] names;
    JSlider[][] scores;
    JLabel[] total;
    JButton exit;
    
    public GolfGUI(){
        JPanel panel1=new JPanel(new FlowLayout());
        panel1.add(new JLabel("How many golfers will there be?"));
        JSpinner spin1=new JSpinner(new SpinnerNumberModel(3,2,10,1));
        panel1.add(spin1);
        JOptionPane.showMessageDialog(null, panel1);
        int num=(int)spin1.getValue();
        System.out.println(num);
        buildFrame(num);
        
        frame.setUndecorated(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void buildFrame(int num){
        frame=new JFrame("Golfer Scores");
        frame.setLayout(new GridLayout(0,4));
        frame.add(new JLabel("Name"));
        frame.add(new JLabel("Front Nine"));
        frame.add(new JLabel("Back Nine"));
        frame.add(new JLabel("Total"));
        names=new JTextField[num];
        scores=new JSlider[num][2];
        total=new JLabel[num];
        
        for (int i = 0; i < num; i++) {
            names[i]=new JTextField();
            frame.add(names[i]);
            scores[i][0]=new JSlider(10,90,36);
            frame.add(adjustSlider(scores[i][0]));
            scores[i][1]=new JSlider(10,90,36);
            frame.add(adjustSlider(scores[i][1]));
            total[i]=new JLabel("Total:     ");
            frame.add(total[i]);
            scores[i][0].addChangeListener(new SliderListener());
            scores[i][1].addChangeListener(new SliderListener());
        }
        
        exit=new JButton("Exit");
        exit.addActionListener(new ExitListener());
        frame.add(exit);
        
    }
    class SliderListener implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            for (int i = 0; i < names.length; i++) {
                total[i].setText("Total: "+(scores[i][0].getValue()+scores[i][1].getValue()));
            }
            frame.pack();

        }
        
    }
    class ExitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
    public JSlider adjustSlider(JSlider s){
        
            s.setMajorTickSpacing(10);
            s.setPaintLabels(true);
            return s;
    }
}