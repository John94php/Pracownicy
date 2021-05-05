package ramka;

import javax.swing.*;
import java.awt.*;

public class showList extends JFrame {
    public showList() {
        initComponents();
    }
    public void initComponents() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        this.setTitle("Lista pracowników");
        this.setBounds(630, 0, width/2, height/2);
        this.setLocationRelativeTo(null);
    }

}
