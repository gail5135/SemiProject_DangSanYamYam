import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainNorthPanel extends JPanel {
    public MainNorthPanel(Container container, CardLayout cards){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400,60));
        this.setBackground(Color.WHITE);

        ImageIcon img = new ImageIcon(getClass().getResource("images/topbar.png"));
        JLabel top = new JLabel(img);
        top.setLayout(new GridLayout(1,6));

        JLabel temp = new JLabel();
        temp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Controller.flag.equals("sub")) {
                    Controller.flag = "main";
                    cards.show(container, "main");
                }
                else if(Controller.flag.equals("cart")){
                    Controller.flag = "sub";
                    cards.show(container, "sub");
                }
                else{
                    cards.show(container, "main");
                }
            }
        });

        top.add(temp);
        this.add(top);
    }
}
