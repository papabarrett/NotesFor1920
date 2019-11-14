
/**
 *
 * @author Barrett Desktop
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CustomerOrder implements ActionListener {

    public static void main(String[] args) throws Exception {
        File f = new File("design.txt");
        f.createNewFile();
        new CustomerOrder();
    }
    JFrame frame;
    ArrayList<JButton> sizeButtons;
    ArrayList<AbstractButton> allButtons;
    JTextField nameField;
    JMenuItem exit;
    Font font, font2, tinyFont, titleFont;
    String fontName1, fontName2, fontName3, welcomeMessage;
    int constraint;
    Color backcolor;

    public CustomerOrder() {
        try {
            Scanner scan = new Scanner(new File("design.txt"));
            fontName1 = scan.nextLine();
            fontName2 = scan.nextLine();
            fontName3 = scan.nextLine();
            welcomeMessage = scan.nextLine();
            backcolor = new Color(scan.nextInt(), scan.nextInt(), scan.nextInt());
            frame = new JFrame();
            constraint = Toolkit.getDefaultToolkit().getScreenSize().height;
            font2 = new Font(fontName1, Font.PLAIN, constraint / 25);
            font = new Font(fontName2, Font.PLAIN, constraint / 25);
            tinyFont = new Font(fontName2, Font.PLAIN, constraint / 75);
            titleFont = new Font(fontName3, Font.PLAIN, constraint / 12);
            JLabel jl = new JLabel(welcomeMessage);
            jl.setFont(titleFont);
            jl.setOpaque(true);
            fixColor(jl);
            BufferedImage img = ImageIO.read(new File("logo.png"));
            Image dimg = img.getScaledInstance(constraint / 7, constraint / 7, Image.SCALE_SMOOTH);
            jl.setIcon(new ImageIcon(dimg));
            frame.setUndecorated(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
            frame.setLayout(new BorderLayout());
            scan = new Scanner(new File("menu.txt"));
            frame.add(jl, BorderLayout.NORTH);
            frame.add(processSizeGroups(scan), BorderLayout.EAST);
            frame.add(buttonPanel, BorderLayout.CENTER);
            allButtons = new ArrayList<AbstractButton>();
            while (scan.hasNext()) {
                buttonPanel.add(processOptions(scan));
            }
            frame.add(getNamePanel(), BorderLayout.SOUTH);
            frame.setJMenuBar(setupMenu());
            //  frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public JPanel getNamePanel() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel n = new JLabel("Name");
        n.setFont(font);
        p.add(n);
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(constraint / 3, constraint / 18));
        nameField.setFont(font);
        p.add(nameField);
        fixColor(p);
        return p;
    }

    public void fixColor(JComponent jc) {
        jc.setOpaque(true);
        jc.setBackground(backcolor);
    }

    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    public void updateButtonText() {
        double mult = 0;
        for (AbstractButton allButton : allButtons) {
            if (allButton.isSelected()) {
                try {
                    Scanner scan = new Scanner(allButton.getActionCommand());
                    mult += scan.nextDouble();
                    // System.out.println(mult);
                } catch (Exception e) {
                }
            }
        }
        for (JButton sizeButton : sizeButtons) {
            try {
                Scanner scan = new Scanner(sizeButton.getActionCommand());
                double price = Math.round(scan.nextDouble() * mult * 4) / 4.0;
                String name = scan.nextLine().trim();
                DecimalFormat df = new DecimalFormat("$#,##0.00");
                sizeButton.setText("<html>" + name.substring(7) + "<br>" + df.format(price) + "</html>");
            } catch (Exception e) {
            }
        }
    }

    public JPanel processSizeGroups(Scanner scan) {
        JPanel p = new JPanel(new GridLayout(0, 1));
        scan.nextLine();
        sizeButtons = new ArrayList<JButton>();
        while (scan.hasNextDouble()) {
            String command = scan.nextLine();
            Scanner scan2 = new Scanner(command);
            double num = scan2.nextDouble();
            String text = scan2.nextLine().trim();
            JButton jb = new JButton(text);
            jb.setFont(font);
            sizeButtons.add(jb);
            jb.addActionListener(this);
            jb.setActionCommand(num + " (size) " + text.toUpperCase());
            p.add(jb);
        }
        return p;
    }

    class ItemChange implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            updateButtonText();
            for (AbstractButton allButton : allButtons) {
                allButton.setFont(font);
                if (allButton.isSelected()) {
                    allButton.setFont(font2);
                }
            }

        }

    }

    public JPanel processOptions(Scanner scan) {
        JPanel basePanel = new JPanel(new BorderLayout());
        // scan.nextLine();
        fixColor(basePanel);
        String name = scan.nextLine();
        JLabel jl = new JLabel(name.substring(4));
        jl.setFont(font);
        jl.setOpaque(true);
        Random r = new Random();
        jl.setBackground(new Color(r.nextInt(50) + 200, r.nextInt(50) + 200, r.nextInt(50) + 200));
        basePanel.add(jl, BorderLayout.NORTH);
        JPanel basePanelButtons = new JPanel(new GridLayout(0, 3));
        basePanel.add(basePanelButtons, BorderLayout.CENTER);
        ButtonGroup bg = new ButtonGroup();
        fixColor(basePanelButtons);
        while (scan.hasNextDouble()) {
            String command = scan.nextLine();
            Scanner scan2 = new Scanner(command);
            double num = scan2.nextDouble();
            String text = scan2.nextLine().trim();
            JCheckBox jb = new JCheckBox(text);
            jb.setFont(font);
            fixColor(jb);
            allButtons.add(jb);
            jb.setActionCommand(num + " (" + name.substring(4).toLowerCase() + ") " + text.toUpperCase());
            jb.addItemListener(new ItemChange());
            if (name.startsWith("+")) {
                bg.add(jb);
            }
            basePanelButtons.add(jb);

        }
        if (name.startsWith("+")) {
            Enumeration elements = bg.getElements();
            AbstractButton button = (AbstractButton) elements.nextElement();
            button.setSelected(true);

        }
        return basePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(frame, "Place Order?", "Place Order?", JOptionPane.YES_NO_OPTION);
        if (choice == 1) {
            return;
        }
        while (new File("wait.txt").exists()) {
            try {
                Thread.sleep(50);
            } catch (Exception e1) {
            }
        }
        double mult = 1, price = -1;
        DecimalFormat df = new DecimalFormat("0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
        try {
            new File("wait.txt").createNewFile();
            PrintWriter out = new PrintWriter(new FileWriter(new File("orders" + sdf.format(new Date()) + ".txt"), true));
            String studentName = "SINNER";
            if (nameField.getText().trim().length() > 1) {
                studentName = nameField.getText().trim();
            }
            out.println(studentName);
            for (JButton sizeButton : sizeButtons) {
                if (sizeButton.getActionCommand().equals(e.getActionCommand())) {
                    Scanner scan = new Scanner(sizeButton.getActionCommand());
                    scan.nextDouble();
                    String drinkName = scan.nextLine().trim();
                    out.println(drinkName);
                }
            }
            for (AbstractButton allButton : allButtons) {
                if (allButton.isSelected()) {
                    try {
                        Scanner scan = new Scanner(allButton.getActionCommand());
                        mult += scan.nextDouble();
                        out.print(scan.nextLine().trim() + " ");
                    } catch (Exception e2) {
                    }
                }
            }
            out.println();
            for (JButton sizeButton : sizeButtons) {
                if (sizeButton.getActionCommand().equals(e.getActionCommand())) {
                    Scanner scan = new Scanner(sizeButton.getActionCommand());
                    price = Math.round(scan.nextDouble() * mult * 4) / 4.0;
                    out.println(df.format(price));
                }
            }
            out.close();
            new File("wait.txt").delete();
        } catch (Exception e2) {
        }
        nameField.setText("");
        for (int i = allButtons.size() - 1; i >= 0; i--) {
            allButtons.get(i).setSelected(true);

        }
        for (int i = allButtons.size() - 1; i >= 0; i--) {
            allButtons.get(i).setSelected(false);
        }

    }

    public JMenuBar setupMenu() {
        JMenuBar m = new JMenuBar();
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ExitListener());
        exit.setFont(tinyFont);
        fixColor(m);
        fixColor(exit);
        m.add(exit);
        return m;
    }

}
