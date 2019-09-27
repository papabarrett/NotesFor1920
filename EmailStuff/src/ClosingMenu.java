
/**
 *
 * @author J. Barrett
 */
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.*;

public class ClosingMenu implements ActionListener {

    public static void main(String[] args) throws Exception {
        new ClosingMenu();
    }
    JFrame frame;
    JMenuItem close, open;
    boolean late;
    Calendar afterlate, day;
    Thread t;

    public ClosingMenu() {
        late = false;
        afterlate = Calendar.getInstance();
        afterlate.set(Calendar.HOUR_OF_DAY, 14);
        afterlate.set(Calendar.MINUTE, 2);
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    late = Calendar.getInstance().after(afterlate);
                    if (late) {

                    }
                }
            }
        };

        t = new Thread(runnable);
        t.start();
        frame = new JFrame();
        JMenuBar jmb = new JMenuBar();
        JMenu file = new JMenu("File");
        jmb.add(file);
        close = new JMenuItem("Close");
        open = new JMenuItem("open");
        file.add(close);
        file.add(open);
        frame.setJMenuBar(jmb);
        close.addActionListener(this);
        open.addActionListener(this);

        JTabbedPane jtb = new JTabbedPane();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        String[] names = {"Briones", "Serota", "Adams"};
        for (String name : names) {
            JTextField t = new JTextField();
            t.addActionListener(this);
            t.setPreferredSize(new Dimension(100, 20));
            System.out.println("Before Setting " + t.getToolTipText());
            t.setToolTipText("Score for " + name);
            panel1.add(t);
            panel1.add(new JLabel("Label"));
        }
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(0, 2));
        for (int i = 0; i < 10; i++) {
            panel2.add(new JLabel("Name " + i));
            panel2.add(new JTextField());
        }
        jtb.addTab("Pane1", panel1);
        jtb.addTab("Grids", panel2);
        frame.add(jtb);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Component[] list = frame.getComponents();
        ArrayList<Component> items = new ArrayList<Component>();
        items = addComps(items, frame);
        for (Component component : items) {
            if (component instanceof JTextField) {
                //gets rid of textfields that have not been given a tool tip.
                String test = ((JTextField) component).getToolTipText() + " y";
                if (test.endsWith("null y")) {
                    continue;
                }
                Scanner scan = new Scanner(((JTextField) component).getToolTipText());
                scan.next();
                scan.next();
                System.out.println("   Last: " + scan.next());

                int score = new Integer(((JTextField) component).getText()) * 10;
                System.out.println(score);
            }
        }

        if (e.getActionCommand().equals(close.getActionCommand())) {
            System.out.println("Saving Stuff");
            System.exit(0);
        }
        if (e.getActionCommand().equals(open.getActionCommand())) {
            System.out.println("Open Pressed");
        }
    }

    public ArrayList<Component> addComps(ArrayList<Component> items, Component comp) {
        System.out.println(comp.getClass());
        items.add(comp);
        if (comp instanceof Container) {
            Container c = (Container) comp;
            System.out.println(c.getComponents().length + "   " + items.size());
            for (Component component : c.getComponents()) {
                items = addComps(items, component);
                System.out.println("inside");
            }
            return items;
        } else {
            if (comp instanceof JTextField) {
                System.out.println(((JTextField) comp).getToolTipText());
            }
            return items;
        }
    }

}
