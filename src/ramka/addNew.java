package ramka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class addNew extends JPanel {

    public addNew() {
        initComponents();
    }

    public void initComponents() {
        ActionListener stoper = new Zegar();

        czas.setFont(new Font("Monospaced", Font.ITALIC, 15));
        Timer zegar = new Timer(1000, stoper);
        zegar.start();
        timePanel.setBackground(Color.BLACK);
        czas.setForeground(Color.WHITE);
        add(nameLabel);
        nameLabel.setText("Podaj imię\r\n");
        add(nameTextField);
        add(surnameLabel);
        surnameLabel.setText("Podaj nazwisko \r\n");
        add(surnameTextField);
        add(PESELLabel);
        PESELLabel.setText("Podaj nr PESEL\r\n");
        add(PESELTextField);
        add(codeAddressLabel);
        codeAddressLabel.setText("Podaj kod pocztowy adresu korespondencyjnego\r\n");
        add(codeAddressTextField);
        add(cityAddressLabel);
        cityAddressLabel.setText("Podaj miejscowość adresu korespondencyjnego\r\n");
        add(cityAddressTextField);
        add(streetAddressLabel);
        streetAddressLabel.setText("Podaj ulicę adresu korespondencyjnego\r\n");
        add(streetAddressTextField);
        add(houseAddressLabel);
        houseAddressLabel.setText("Podaj numer domu adresu korespondencyjnego\r\n");
        add(houseAddressTextField);
        saveButton.setText("Zapisz");
        add(saveButton, BorderLayout.SOUTH);
        timePanel.add(czas);
        this.add(timePanel, BorderLayout.SOUTH);
        this.setLayout(new GridLayout(17,1));
    }

    Action actionsave = new ActionSave("Zapisz");
    JPanel timePanel = new JPanel();


    JLabel nameLabel = new JLabel();
    JLabel surnameLabel = new JLabel();
    JLabel PESELLabel = new JLabel();
    JLabel codeAddressLabel = new JLabel();
    JLabel cityAddressLabel = new JLabel();
    JLabel streetAddressLabel = new JLabel();
    JLabel houseAddressLabel = new JLabel();
    JTextField houseAddressTextField = new JTextField("", 1);
    JTextField streetAddressTextField = new JTextField("", 1);
    JTextField cityAddressTextField = new JTextField("", 1);
    JTextField codeAddressTextField = new JTextField("", 1);
    JTextField nameTextField = new JTextField("", 1);
    JTextField surnameTextField = new JTextField("", 1);
    JTextField PESELTextField = new JTextField("", 1);
    JLabel czas = new JLabel(pobierzCzas());
    JButton saveButton = new JButton(actionsave);

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
        return "" + h + ":" + min + ":" + sec + " \n " + date;

    }

    private static class ActionSave extends AbstractAction {
        public ActionSave(String nazwa) {
            this.putValue(Action.NAME, nazwa);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Zapisano");
        }
    }

}
