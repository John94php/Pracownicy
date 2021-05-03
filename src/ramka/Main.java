package ramka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main extends JFrame {
    public Main() {
        initComponents();
    }

    public void initComponents() {
        JLabel czas = new JLabel(pobierzCzas());
        czas.setFont(new Font("Monospaced", Font.ITALIC, 15));

        ActionListener stoper = new Zegar();
        Timer zegar = new Timer(1000, stoper);
        zegar.start();
        this.setTitle("Pracownicy");
        this.setBounds(300, 300, 300, 200);
        panelMenu.setLayout(new GridLayout(5, 1));
        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);
        panelMenu.add(menu4);
        panelMenu.add(czas);
        container.add(panelMenu);
        this.setDefaultCloseOperation(3);

    }

    private final Container container = this.getContentPane();
    private final JPanel panelMenu = new JPanel();
    private final MenuButton menu1 = new MenuButton("Dodaj pracownika");
    private final MenuButton menu2 = new MenuButton("Lista pracownikow");
    private final MenuButton menu3 = new MenuButton("Usuń pracownika");
    private final MenuButton menu4 = new MenuButton("Edytuj pracownika");

    private class MenuButton extends JButton {
        public MenuButton(String nazwa) {
            super(nazwa);
        }
    }

    private class Zegar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    public String pobierzCzas() {
        GregorianCalendar kalendarz = new GregorianCalendar();
        String h = "" + kalendarz.get(Calendar.HOUR_OF_DAY);
        String min = "" + kalendarz.get(Calendar.MINUTE);
        String sec = "" + kalendarz.get(Calendar.SECOND);
        String day = "" + kalendarz.get(Calendar.DAY_OF_MONTH);
        String month = "" + kalendarz.get(Calendar.MONTH);
        String year = "" + kalendarz.get(Calendar.YEAR);
        if (Integer.parseInt(h) < 10) {
            h = "0" + h;
        } else if (Integer.parseInt(min) < 10) {
            min = "0" + min;
        } else if (Integer.parseInt(sec) < 10) {
            sec = "0" + sec;
        }
        String date = "" + day + "." + month + "." + year;
        return "" + h + ":" + min + ":" + sec + "|| " + date;

    }

    static int i = 1;

    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}
