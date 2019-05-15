import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel{
    private JPanel panel;
    private JButton btnLogin;
    private JButton btnInit;
    private HintPassField passText;
    private HintTextField userText;
    private JFrame frame;

    public LoginPanel(JFrame frame) {
        // setting
        this.frame = frame;

        setSize(500, 800);
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new BorderLayout());
        north.setPreferredSize(new Dimension(500,250));
        north.setBackground(Color.WHITE);


        JLabel northLabel = new JLabel(new ImageIcon(getClass().getResource("images/logo.png")));

        north.add(northLabel, BorderLayout.CENTER);

        // panel
        panel = new JPanel();
        placeLoginPanel(panel);
        panel.setBackground(Color.white);
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                userText.setShowingHint(true);
            }
        });

        this.add(north, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);

        frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    northLabel.requestFocus();
                }
            }
        );
    }

    public void placeLoginPanel(JPanel panel){
        panel.setLayout(null);

        userText = new HintTextField("  아이디 ");
        userText.setBounds(40, 0, 420, 50);
        panel.add(userText);

        passText = new HintPassField("  비밀번호 ");
        passText.setBounds(40, 40, 420, 50);
        passText.setForeground(Color.gray);
        panel.add(passText);


        btnLogin = new JButton("로그인");
        btnLogin.setBounds(44, 110, 412, 50);
        btnLogin.setForeground(Color.white);
        btnLogin.setBackground(new Color(230,75,38));
        btnLogin.setOpaque(true);
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck((CardLayout)frame.getContentPane().getLayout());
            }
        });
        panel.add(btnLogin);


        btnInit = new JButton("회원가입");
        btnInit.setBounds(44, 170, 412, 50);
        btnInit.setForeground(Color.black);
        btnInit.setBackground(new Color(238,238,238));
        btnInit.setOpaque(true);
        btnInit.setBorderPainted(false);
        btnInit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegistPanel((CardLayout)frame.getContentPane().getLayout());
            }
        });
        panel.add(btnInit);
    }

    public void isLoginCheck(CardLayout cards) {
        String id = userText.getText();
        String pw = passText.getText();
        Controller.member.getKey();

        if(Controller.member.isMember(id, pw)){
            cards.show(frame.getContentPane(), "main");
        }
    }

    public void openRegistPanel(CardLayout cards){
        cards.show(frame.getContentPane(), "regist");
    }
}