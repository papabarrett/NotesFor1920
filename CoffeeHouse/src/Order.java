
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student
 */
public class Order {

    String studentName;
    double price;
    DecimalFormat df;
    String size, orderDetails;
    JButton clear;
    Font font;
    Color pastel;

    boolean cleared;

    public Order(Scanner scan, Font f) {
        cleared = false;
        pastel = getRandomPastel();
        font = f;
        studentName = scan.nextLine();
        size = scan.nextLine();
        orderDetails = scan.nextLine();
        price = scan.nextDouble();
        scan.nextLine();
        df = new DecimalFormat("$#,##0.00");
        clear = new JButton(df.format(price));
        clear.setPreferredSize(new Dimension(400, 200));
        clear.setFont(font);
        clear.addActionListener(new ClearListener());
    }

    public void write(PrintWriter out) {
        out.println(studentName);
        out.println(size);
        out.println(orderDetails);
        out.println(price);
        out.flush();
    }

    class ClearListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
                File file = new File("orders" + sdf.format(new Date()) + "cleared.txt");
                PrintWriter out = new PrintWriter(new FileWriter(file, true));
                write(out);
                out.println("====================================");
                out.close();
            } catch (Exception e2) {
            }
            cleared = true;
        }

    }

    public JPanel getPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.add(clear, BorderLayout.EAST);
        String line = "<html>" + studentName + "<br>";
        line += size + "<br>";
        line += orderDetails + "</html>";
        JLabel label = new JLabel(line);
        label.setFont(font);
        label.setOpaque(true);
        label.setBackground(getPastel());
        p.add(label, BorderLayout.CENTER);

        return p;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getPastel() {
        return pastel;
    }

    public void setPastel(Color pastel) {
        this.pastel = pastel;
    }

    public Color getRandomPastel() {
        Random r = new Random();
        return new Color(r.nextInt(50) + 200, r.nextInt(50) + 200, r.nextInt(50) + 200);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public JButton getClear() {
        return clear;
    }

    public void setClear(JButton clear) {
        this.clear = clear;
    }

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

}
