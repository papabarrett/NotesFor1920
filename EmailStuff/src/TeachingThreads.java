/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class TeachingThreads {
    Thread t;
    JLabel label;
    public static void main(String[] args) throws Exception {
        new TeachingThreads();
    }
    public TeachingThreads(){
        JFrame frame=new JFrame();
        label=new JLabel("Junk");
        frame.add(label);
        
        Runnable runnable = new Runnable() {
            public void run() {
                while(true){
                    SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
                    label.setText(sdf.format(System.currentTimeMillis())+"");
                    frame.pack();
                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {
                    }
                }
            }
        };
        t=new Thread(runnable);
        t.start();
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}