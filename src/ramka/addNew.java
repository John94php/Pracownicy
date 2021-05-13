package ramka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
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
        add(flatAddressLabel);
        flatAddressLabel.setText("Poda numer mieszkania adresu korespondencyjnego");
        add(flatAddressTextField);
        saveButton.setText("Zapisz");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getName = nameTextField.getText();
                String getSurname = surnameTextField.getText();
                String getPESEL = PESELTextField.getText();
                String getZip = codeAddressTextField.getText();
                String getCity = cityAddressTextField.getText();
                String getStreet = streetAddressTextField.getText();
                String getHouse = houseAddressTextField.getText();
                String getFlat = flatAddressTextField.getText();
                Date czas = new Date();
                String created = String.format("%1$td.%1$tm.%1$tY %tT %n",czas);
                PrintWriter plik = null;
                try {
                    plik = new PrintWriter(new FileWriter("pracownicy.csv",true));
                    plik.printf("%s %s %s %s %s %s %s %s %s",getName,getSurname,getPESEL,getZip,getCity,getStreet,getHouse,getFlat,created);
                    plik.close();
                    JOptionPane.showMessageDialog(null,"Dodano");
                    nameTextField.setText("");
                    surnameTextField.setText("");
                    PESELTextField.setText("");
                    codeAddressTextField.setText("");
                    cityAddressTextField.setText("");
                    streetAddressTextField.setText("");
                    houseAddressTextField.setText("");
                    flatAddressTextField.setText("");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        add(saveButton, BorderLayout.SOUTH);
        timePanel.add(czas);
        this.add(timePanel, BorderLayout.SOUTH);
        this.setLayout(new GridLayout(18,1));
    }


    JPanel timePanel = new JPanel();


    JLabel nameLabel = new JLabel();
    JLabel surnameLabel = new JLabel();
    JLabel PESELLabel = new JLabel();
    JLabel codeAddressLabel = new JLabel();
    JLabel cityAddressLabel = new JLabel();
    JLabel streetAddressLabel = new JLabel();
    JLabel houseAddressLabel = new JLabel();
    JLabel flatAddressLabel = new JLabel();
    JTextField flatAddressTextField = new JTextField("",1);
    JTextField houseAddressTextField = new JTextField("", 1);
    JTextField streetAddressTextField = new JTextField("", 1);
    JTextField cityAddressTextField = new JTextField("", 1);
    JTextField codeAddressTextField = new JTextField("", 1);
    JTextField nameTextField = new JTextField("", 1);
    JTextField surnameTextField = new JTextField("", 1);
    JTextField PESELTextField = new JTextField("", 1);
    JLabel czas = new JLabel(pobierzCzas());
    JButton saveButton = new JButton("Zapisz");

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

//    private static class ActionSave extends AbstractAction {
//
//        public ActionSave(String nazwa) {
//            this.putValue(Action.NAME, nazwa);
//
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("Zapisano");
//            // Zapis do pliku (?)
//            try {
//                String name = "Jan";
//                String surname = "Wolff";
//                String PESEL = "94060810321";
//                String zipcode = "80-156";
//                String city = "Gdańsk";
//                String street = "Kartuska";
//                String house = "77a";
//                String flat = "6";
//
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//
//        }
//    }

}
