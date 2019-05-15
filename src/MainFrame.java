import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private MainCenterPanel mainPanel;
    private CardLayout centerCards;
    private JPanel login;
    private JPanel mainWhole;
    private JPanel regist;
    private Member member;

    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(centerCards = new CardLayout());
        this.setTitle("당산얌얌");
        this.setSize(500,800);
        this.setLocation(400, 100);

        Container mainPane = this.getContentPane();
        mainPane.setBackground(Color.WHITE);
        mainPane.setLayout(new CardLayout());

        member = new Member();

        login = new LoginPanel(this);
        regist = new RegistPanel(this);
        mainWhole = new MainWholePanel();

        mainPane.add(login, "login");
        mainPane.add(regist, "regist");
        mainPane.add(mainWhole, "main");


        this.setVisible(true);

    }
}
