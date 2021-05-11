package ramka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main extends JFrame implements WindowListener {
    public Main() {
        initComponents();
    }

    public void initComponents() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        this.setTitle("Zarządzanie pracownikami " );
        this.setBounds(0,0,width,height-25);
        this.setLayout(new GridLayout(1,1));
        this.addWindowListener(this);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        menu.add(menu1);
        menu.add(menu2);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(application);
        application.addTab("Dodaj pracownika",new addNew());
        application.addTab("Lista pracowników",new showList());
    }

    private JTabbedPane application = new JTabbedPane();
    JPanel menu =  new JPanel();
    JPanel panel1 = new JPanel();

    MenuButton menu1 = new MenuButton("Dodaj pracownika");
    MenuButton menu2 = new MenuButton("Lista pracownikow");
    private int i = 0;



    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(menu,"Witaj");
    }

    @Override
    public void windowClosing(WindowEvent e) {
   int opcja =      JOptionPane.showConfirmDialog(menu,"Czy na pewno chcesz wyjść?");
        if(opcja == 0) {
            JOptionPane.showMessageDialog(menu,"Do zobaczenia");

            this.setDefaultCloseOperation(3);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    private class MenuButton extends JButton implements FocusListener, ActionListener {
        public MenuButton(String nazwa) {
            super(nazwa);
            this.addFocusListener(this);
            this.addActionListener(this);
            this.addKeyListener(new KeyAdapter() {


                @Override
                public void keyPressed(KeyEvent e) {
                    keyPressedHandler(e);
                }

            });

        }

        @Override
        public void focusGained(FocusEvent e) {
            this.setBackground(Color.darkGray);
            this.setForeground(Color.WHITE);
        }

        @Override
        public void focusLost(FocusEvent e) {
            this.setBackground(null);
            this.setForeground(null);
        }

        private void keyPressedHandler(KeyEvent e) {
            int lMenu = menu.getComponentCount(); // length of menu
            if (i == 0) i = 10 * lMenu;
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                menu.getComponent(++i % lMenu).requestFocus();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {

                menu.getComponent(--i % lMenu).requestFocus();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                menu.getComponent(++i % lMenu).requestFocus();

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                menu.getComponent(--i % lMenu).requestFocus();

            } else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                ((MenuButton)e.getSource()).doClick();
            }


        }

        @Override
        public void actionPerformed(ActionEvent e) {
           String opcja =  ((MenuButton)e.getSource()).getText();
                if(opcja == "Dodaj pracownika")
                new addNew().setVisible(true);
                if(opcja == "Lista pracownikow")
                    new showList().setVisible(true);
                if(opcja == "Edytuj pracownika") {
                    new edit().setVisible(true);
                }

        }

    }



    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}
