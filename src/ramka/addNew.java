package ramka;

import javax.swing.*;
import java.awt.*;

public class addNew extends JFrame {
    public addNew() {
        initComponents();
    }

    public void initComponents() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        this.setTitle("Dodaj pracownika");
        this.setBounds(630, 0, width/2, height/2);
            this.setLocationRelativeTo(null);
    }
}
