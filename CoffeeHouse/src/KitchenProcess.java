
/**
 *
 * @author Barrett Desktop
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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

    public KitchenProcess() {
        try {
            frame = new JFrame();

            font = new Font("Forte", Font.PLAIN, 45);
            font2 = new Font("Copperplate Gothic", Font.PLAIN, 45);
            frame.setUndecorated(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ordersPanel = new JScrollPane();

            frame.setLayout(new BorderLayout());
            frame.add(ordersPanel, BorderLayout.CENTER);
            frame.setJMenuBar(setupMenu());
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
            file = new File("orders" + sdf.format(new Date()) + ".txt");
            orders = new ArrayList<Order>();
            pastels=new ArrayList<Color>();
            loadOrders();
            for (Order order : orders) {
                pastels.add(order.getPastel());
            }
            if (file.exists()) {
                ordersPanel.setViewportView(getSomeOrdersPanel());
            } else {
                ordersPanel.setViewportView(getNoOrdersPanel());
            }
            timer = new javax.swing.Timer(1000*1, this);
            timer.start();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public JPanel getNoOrdersPanel() {
        JPanel p = new JPanel();
        p.add(new JLabel("No orders yet"));
        return p;
    }
    
    public void loadOrders(){
        try {
            Scanner scan = new Scanner(file);
            System.out.println("t");
            while(scan.hasNext()){
            System.out.println("t");
                orders.add(new Order(scan,font));
                System.out.println(orders.size());
            }
        } catch (Exception e) {
        }
        
    }

    public JPanel getSomeOrdersPanel() {
        try {
            System.out.println("g");
            getNewOrders();
            clearOrders();
            Scanner scan = new Scanner(file);
            if (!scan.hasNext()) {
                return getNoOrdersPanel();
            }
            System.out.println("g");
            JPanel p = new JPanel(new GridLayout(0, 1));
            for (Order order : orders) {
                p.add(order.getPanel());
                System.out.println(order.getStudentName());
            }

            return p;

        } catch (Exception e) {
            System.out.println(e);
            return getNoOrdersPanel();
        }
    }

    public void clearOrders() {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).isCleared()) {
                System.out.println(orders.get(i).studentName);
                orders.remove(i);
                pastels.remove(i);
                i = 0;
            }
        }
        writeAllOrders();
    }

    public void getNewOrders() {
        try {
            Scanner scan = new Scanner(file);
            System.out.println(orders.size());
            for (int i = 0; i < orders.size(); i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.println(scan.nextLine());
                }
            }
            while (scan.hasNext()) {
                orders.add(new Order(scan,font));
                pastels.add(orders.get(orders.size()-1).getPastel());
            }
            scan.close();
        } catch (Exception e) {
        }
    }

    public void writeAllOrders() {
        try {
            PrintWriter out = new PrintWriter(file);
            for (Order order : orders) {
                order.write(out);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
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
