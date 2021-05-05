package ramka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame implements WindowListener {
    public Main() {
        initComponents();
    }

    public void initComponents() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        this.setTitle("Zarządzanie pracownikami " );
        this.setBounds(0, 0, width/2, height/2);
        this.addWindowListener(this);
        panelMenu.setLayout(new GridLayout(4, 1));
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);
        panelMenu.add(menu4);
        container.add(panelMenu);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);

    }


    JPanel panelMenu = new JPanel();
    JPanel panelCzas = new JPanel();
    Container container = this.getContentPane();
    MenuButton menu1 = new MenuButton("Dodaj pracownika");
    MenuButton menu2 = new MenuButton("Lista pracownikow");
    MenuButton menu3 = new MenuButton("Edytuj pracownika");
    MenuButton menu4 = new MenuButton("Usuń pracownika");

    private int i = 0;

    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(container,"Witaj");
    }

    @Override
    public void windowClosing(WindowEvent e) {
   int opcja =      JOptionPane.showConfirmDialog(container,"Czy na pewno chcesz wyjść?");
        if(opcja == 0) {
            JOptionPane.showMessageDialog(container,"Do zobaczenia");

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
            int lMenu = panelMenu.getComponentCount(); // length of menu
            if (i == 0) i = 10 * lMenu;
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                panelMenu.getComponent(++i % lMenu).requestFocus();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {

                panelMenu.getComponent(--i % lMenu).requestFocus();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                panelMenu.getComponent(++i % lMenu).requestFocus();

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                panelMenu.getComponent(--i % lMenu).requestFocus();

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
