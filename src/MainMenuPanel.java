import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuPanel extends JPanel {
    private JLabel menu;
    private JLabel[] invisibleLabel;
    private MainCenterPanel mainCenter;

    public MainMenuPanel(Container container, CardLayout cards){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.mainCenter = (MainCenterPanel)container;

        menu = new JLabel(new ImageIcon(getClass().getResource("images/MainMenu.png")));
        menu.setLayout(new GridLayout(4,3));

        invisibleLabel = new JLabel[12];

        for(int i = 0; i < 12; i++){
            JLabel temp = new JLabel();
            temp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mainCenter.setSubMenu(new SubMenuPanel(container, cards));
                    Controller.flag = "sub";
                    cards.show(container,"sub");
                }
                @Override
                public void mouseEntered(MouseEvent e){
                    temp.setBorder(BorderFactory.createLineBorder(new Color(230,75,38),2));
                }
                public void mouseExited(MouseEvent e){
                    temp.setBorder(BorderFactory.createEmptyBorder());
                }
            });
            invisibleLabel[i] = temp;
            menu.add(invisibleLabel[i]);
        }

        this.add(menu,BorderLayout.CENTER);
    }
}
