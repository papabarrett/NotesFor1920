
/**
 *
 * @author Barrett Desktop
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class KitchenProcess implements ActionListener {

    public static void main(String[] args) throws Exception {
        new KitchenProcess();
    }
    JFrame frame;
    javax.swing.Timer timer;
    Font font, font2;
    JMenuItem exit;
    File file;
    JScrollPane ordersPanel;
    ArrayList<Order> orders;
    ArrayList<Color> pastels;
    int constraint;

    public KitchenProcess() {
        try {
            constraint = Toolkit.getDefaultToolkit().getScreenSize().height;
            frame = new JFrame();

            font = new Font("Forte", Font.PLAIN, constraint / 25);
            font2 = new Font("Copperplate Gothic", Font.PLAIN, constraint / 25);
            frame.setUndecorated(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ordersPanel = new JScrollPane();

            frame.setLayout(new BorderLayout());
            frame.add(ordersPanel, BorderLayout.CENTER);
            frame.setJMenuBar(setupMenu());
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
            file = new File("orders" + sdf.format(new Date()) + ".txt");
            orders = new ArrayList<Order>();
            pastels = new ArrayList<Color>();
            loadOrders();
            for (Order order : orders) {
                pastels.add(order.getPastel());
            }
            if (file.exists()) {
                ordersPanel.setViewportView(getSomeOrdersPanel());
            } else {
                ordersPanel.setViewportView(getNoOrdersPanel());
            }
            timer = new javax.swing.Timer(500 * 1, this);
            timer.start();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
        }
    }

    public JPanel getNoOrdersPanel() {
        JPanel p = new JPanel();
        p.add(new JLabel("No orders yet"));
        return p;
    }

    public void loadOrders() {
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                orders.add(new Order(scan, font));
            }
        } catch (Exception e) {
        }

    }

    public JPanel getSomeOrdersPanel() {
        try {
            getNewOrders();
            clearOrders();
            Scanner scan = new Scanner(file);
            if (!scan.hasNext()) {
                return getNoOrdersPanel();
            }
            JPanel p = new JPanel(new GridLayout(0, 1));
            for (Order order : orders) {
                p.add(order.getPanel());
            }

            return p;

        } catch (Exception e) {
            return getNoOrdersPanel();
        }
    }

    public void clearOrders() {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).isCleared()) {
                orders.remove(i);
                pastels.remove(i);
                i = 0;
            }
        }
        writeAllOrders();
    }

    public void getNewOrders() {
        try {
             while (new File("wait.txt").exists()) {
                Thread.sleep(50);
            }
            new File("wait.txt").createNewFile();
            Scanner scan = new Scanner(file);
            for (int i = 0; i < orders.size(); i++) {
                for (int j = 0; j < 4; j++) {
                    scan.nextLine();
                }
            }
            while (scan.hasNext()) {
                orders.add(new Order(scan, font));
                pastels.add(orders.get(orders.size() - 1).getPastel());
            }
            scan.close();            
            new File("wait.txt").delete();
        } catch (Exception e) {
        }
    }

    public void writeAllOrders() {
        try {
            while (new File("wait.txt").exists()) {
                Thread.sleep(50);
            }
            new File("wait.txt").createNewFile();
            PrintWriter out = new PrintWriter(file);
            for (Order order : orders) {
                order.write(out);
            }
            out.close();
            new File("wait.txt").delete();
        } catch (Exception e) {
        }
    }

    public JMenuBar setupMenu() {
        JMenuBar m = new JMenuBar();
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ExitListener());
        exit.setFont(font);
        m.add(exit);
        return m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (file.exists()) {
            ordersPanel.setViewportView(getSomeOrdersPanel());
        } else {
            ordersPanel.setViewportView(getNoOrdersPanel());
        }

    }

    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

}
