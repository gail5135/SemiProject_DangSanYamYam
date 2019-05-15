import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainSouthPanel extends JPanel {
    public MainSouthPanel(Container container, CardLayout cards){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(230, 75, 38));

        ImageIcon img = new ImageIcon(getClass().getResource("images/dock.png"));
        JLabel dock = new JLabel(img);
        dock.setLayout(new GridLayout(1,4));

        JLabel[] invisibleLabel = new JLabel[4];
        for(int i = 0; i < 4; i++){
            JLabel temp = new JLabel();
            invisibleLabel[i] = temp;
            dock.add(invisibleLabel[i]);
        }

        invisibleLabel[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cards.show(container, "main");
                Controller.flag = "main";
            }
        });

        invisibleLabel[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cards.show(container, "search");
                Controller.flag = "search";
            }
        });

        invisibleLabel[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cards.show(container, "cart");
                Controller.flag = "cart";
            }
        });

        this.add(dock, BorderLayout.CENTER);


    }
}
