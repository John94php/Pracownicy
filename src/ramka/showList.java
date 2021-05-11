package ramka;

import javax.swing.*;
import java.awt.*;

public class showList extends JPanel {
    public showList() {
        initComponents();
    }
    public void initComponents() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        this.setBounds(630, 0, width/2, height/2);
        this.add(table);
        table.setFillsViewportHeight(true);
        this.setLayout(new BorderLayout());
        this.add(table.getTableHeader(), BorderLayout.PAGE_START);
        this.add(table, BorderLayout.CENTER);

    }
        String[] columns = {
            "Imię",
            "Nazwisko",
            "PESEL",
            "Kod pocztowy",
            "Miejscowość",
            "Ulica",
            "Nr domu",
            "Nr mieszkania"

        };
    Object[][] data = {
            {"Jan","Zalesiński","94030210412","80-156","Gdańsk","Kartuska ","77A","6"}
    };
    JTable table = new JTable(data,columns);

}
