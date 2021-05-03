package ramka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main  extends JFrame {
    public Main() {

        int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(szer / 2, wys / 2);
        int szerRamki = this.getSize().width;
        int wysRamki = this.getSize().height;
        this.setLocation((szer - szerRamki) / 2, (wys - wysRamki) / 2);
        initComponents();
        this.setTitle("Pracownicy");
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
    }

    public void initComponents() {

        add = new JButton("Dodaj pracownika");
        list = new JButton("Lista pracowników");
        edit = new JButton("Edytuj pracownika");
        add.setLocation(10, 25);

        list.setLocation(215, 25);
        edit.setLocation(420, 25);
        add.setSize(200, 30);
        list.setSize(200, 30);
        edit.setSize(200, 30);
        container.add(add);
        container.add(list);
        container.add(edit);
        container.add(czas);
        czas.setFont(new Font("Monospace",Font.ITALIC,15));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Akcja");
            }
        });
        ActionListener stoper = new Zegar();
        Timer zegar = new Timer(1000, stoper);
        zegar.start();

    }

    JButton add;
    JButton list;
    JButton edit;
    JRadioButton M = new JRadioButton("Mężczyzna", false);
    JRadioButton K = new JRadioButton("Kobieta", false);
    Container container = this.getContentPane();
    JLabel czas = new JLabel(pobierzCzas());

    private class Zegar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            czas.setText(pobierzCzas());
        }
    }

    public String pobierzCzas() {
        GregorianCalendar kalendarz = new GregorianCalendar();
        String h = "" + kalendarz.get(Calendar.HOUR_OF_DAY);
        String min = "" + kalendarz.get(Calendar.MINUTE);
        String sec = "" + kalendarz.get(Calendar.SECOND);
        if (Integer.parseInt(h) < 10) {
            h = "0" + h;
        } else if (Integer.parseInt(min) < 10) {
            min = "0" + min;
        } else if (Integer.parseInt(sec) < 10) {
            sec = "0" + sec;
        }
        return "" + h + ":" + min + ":" + sec;

    }

    static int i = 1;

    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}
