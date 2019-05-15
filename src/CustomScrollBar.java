import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBar extends BasicScrollBarUI {


    public void configureScrollBarColors(){
        trackColor = Color.WHITE;
        this.thumbColor = Color.WHITE;
    }

    protected JButton createIncreaseButton(int orientation ){
        JButton button = new JButton();
        button.setBackground(Color.WHITE);
        button.setBorder(null);
        return button;
    }

    protected JButton createDecreaseButton(int orientation ){
        JButton button = new JButton();
        button.setBackground(Color.WHITE);
        button.setBorder(null);
        return button;
    }

}
