import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchPanel extends JPanel {
    public SearchPanel(Container container, CardLayout cards){
        this.setLayout(new BorderLayout());
        this.add(new JLabel(new ImageIcon(getClass().getResource("images/search.png"))));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cards.show(container, "main");
            }
        });
    }
}
