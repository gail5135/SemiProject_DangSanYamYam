import javax.swing.*;
import java.awt.*;

public class MainWholePanel extends JPanel {
    private JPanel mainNorth;
    private JPanel mainCenter;
    private JPanel mainSouth;

    public MainWholePanel(){
        this.setLayout(new BorderLayout());

        mainCenter = new MainCenterPanel();
        mainNorth = new MainNorthPanel(mainCenter, (CardLayout)mainCenter.getLayout());
        mainSouth = new MainSouthPanel(mainCenter, (CardLayout)mainCenter.getLayout());

        this.add(mainNorth, BorderLayout.NORTH);
        this.add(mainCenter, BorderLayout.CENTER);
        this.add(mainSouth, BorderLayout.SOUTH);
    }
}
