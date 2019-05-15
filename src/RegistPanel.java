import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

import javax.swing.JPasswordField;

public class RegistPanel extends JPanel {
    /* 생성자 Register를 JFrame으로 상속받아 생성하였으며
     * 각각 JLabel,JPanel,JTextField,JPasswordField,JButton,JLabel,String 을 사용하여
     * 만들어 주었습니다
     * */
    private JFrame frame;

    private  JLabel Title = new JLabel(new ImageIcon("images/logo.png"));
    private JPanel logoPanel = new JPanel();

    private JPanel signUpPanel= new JPanel(new GridLayout(11,0,0,5));
    //Title은 JLabel , signUpPanel은 JPanel(GridLayout(11,0,0,5)
    private JTextField emailField = new HintTextField("  이메일을 입력해주세요");
    private JPasswordField passField = new HintPassField("  비밀번호를 입력해주세요");
    private JPasswordField passcheckField = new HintPassField("  비밀번호 재입력");
    private JTextField phoneField = new HintTextField("  전화번호를 입력해주세요");
    private JTextField addrField = new HintTextField("  주소를 입력해주세요");
    //JTextField에 해당하는 객체는 emailField,phoneField,addrField
    //JPasswordField에 해당하는 객체는 passField,passcheckField
    private JLabel pwlabel = new JLabel("");
    private String passPattern = "/^.*(?=.{8,15})(?=.*[0-9])(?=.*[a-zA-Z]).*$/";
    private String email,pass,phone,addr;
    //pwlabel 과 스트링 Pattern,email,pass,phone,addr
    private JButton regbutton = new JButton();
    private JPanel idPanel = new MyJPanel(0,8,0,8);
    private JPanel pwPanel = new MyJPanel(0,8,0,8);
    private JPanel pwcPanel = new MyJPanel(0,8,0,8);
    private JPanel phoPanel = new MyJPanel(0,8,0,8);
    private JPanel addPanel = new MyJPanel(0,8,0,8);
    // id pw pwc pho add 패널들

    public RegistPanel(JFrame frame) {
        this.frame = frame;

        this.setLayout(new BorderLayout());
        logoPanel.setSize(500, 250);
        logoPanel.setBackground(Color.WHITE);
        logoPanel.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        logoPanel.add(Title);

        regbutton.setBorderPainted(false);
        regbutton.setBorder(null);
        regbutton.setMargin(new Insets(0, 0, 0, 0));
        regbutton.setContentAreaFilled(false);
        regbutton.setIcon(new ImageIcon(getClass().getResource("images/regist.png")));
        regbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               isMember((CardLayout)frame.getContentPane().getLayout());
            }
        });

        idPanel.setBackground(Color.white);
        idPanel.setLayout(new BorderLayout(8,0));
        idPanel.add(new JLabel(new ImageIcon(getClass().getResource("images/idIcon.png"))), BorderLayout.WEST);
        idPanel.add(emailField, BorderLayout.CENTER);

        pwPanel.setBackground(Color.white);
        pwPanel.setLayout(new BorderLayout(8,0));
        pwPanel.add(new JLabel(new ImageIcon(getClass().getResource("images/pwIcon.png"))), BorderLayout.WEST);
        pwPanel.add(passField, BorderLayout.CENTER);

        pwcPanel.setBackground(Color.white);
        pwcPanel.setLayout(new BorderLayout(8,0));
        pwcPanel.add(new JLabel(new ImageIcon(getClass().getResource("images/pwIcon.png"))), BorderLayout.WEST);
        pwcPanel.add(passcheckField, BorderLayout.CENTER);

        phoPanel.setBackground(Color.white);
        phoPanel.setLayout(new BorderLayout(8,0));
        phoPanel.add(new JLabel(new ImageIcon(getClass().getResource("images/phoneIcon.png"))), BorderLayout.WEST);
        phoPanel.add(phoneField, BorderLayout.CENTER);

        addPanel.setBackground(Color.white);
        addPanel.setLayout(new BorderLayout(8,0));
        addPanel.add(new JLabel(new ImageIcon(getClass().getResource("images/addrIcon.png"))), BorderLayout.WEST);
        addPanel.add(addrField, BorderLayout.CENTER);

        signUpPanel.setBackground(Color.white);
        signUpPanel.add(idPanel);
        signUpPanel.add(pwPanel);
        signUpPanel.add(pwcPanel);
        signUpPanel.add(pwlabel);
        signUpPanel.add(phoPanel);
        signUpPanel.add(addPanel);
        signUpPanel.add(regbutton);
        signUpPanel.setPreferredSize(new Dimension(500,800));

        this.checkValue();
        this.CheckText();

        frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    regbutton.requestFocus();
                }
            }
        );

        this.add(logoPanel, BorderLayout.NORTH);
        this.add(signUpPanel, BorderLayout.CENTER);

    }// signUpDialog

    public void checkValue() {
        regbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(emailField.getText().trim().length()==0||emailField.getText().trim().equals("아이디")) {
                    JOptionPane.showMessageDialog(null,"이메일을 입력해 주세요");
                    return;
                }
                if(passField.getText().trim().length()==0) {
                    JOptionPane.showMessageDialog(null,"비밀번호를 입력해주세요","비밀번호를 입력해주세요",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(passcheckField.getText().trim().length()==0) {
                    JOptionPane.showMessageDialog(null,"비밀번호 확인을 입력해주세요","비밀번호 확인을 입력해주세요",JOptionPane.WARNING_MESSAGE);
                }
                if(!passField.getText().trim().equals(passcheckField.getText().trim())) {
                    JOptionPane.showMessageDialog(null,"비밀번호가 같지 않습니다","비밀번호 확인",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(phoneField.getText().trim().length()==0) {
                    JOptionPane.showMessageDialog(null,"휴대폰번호를 입력하세요","휴대폰번호를 입력하세요",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(addrField.getText().trim().length()==0) {
                    JOptionPane.showMessageDialog(null,"주소를 입력하세요","주소를 입력하세요",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        });//addActionListener
    }// checkValue

    public void CheckText() {

        emailField.addFocusListener(new FocusListener() {
            boolean showingHint = true;
            @Override
            public void focusGained(FocusEvent e) {
                if(emailField.getText().isEmpty()) {
                    emailField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(emailField.getText().isEmpty()) {
                    setForeground(Color.gray);
                    emailField.setText("이메일을입력해주세요");

                }
            }

            public String getText() {
                return showingHint ? "" : emailField.getText();
            }


        });
        passField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if(passField.getText().trim().equals("비밀번호")) {
                    passField.setText("");
                }
                if (passcheckField.getText().trim().length() == 0) {

                    pwlabel.setText("      8-15자의 영문,숫자,특수문자 등 3종류 이상을 조합해 주세요.");
                    pwlabel.setForeground(Color.RED);
                }//비밀번호입력 가이드
            }

            @Override
            public void focusLost(FocusEvent e) {

                if(Pattern.matches(passPattern,passField.getText())) {
                    System.out.println();
                }

                pwlabel.setText("");

            }
        });
    }//CheckText

    public void isMember(CardLayout cards){
        email = emailField.getText();
        pass = String.valueOf(passField.getPassword());
        phone = phoneField.getText();
        addr = addrField.getText();
        if(Controller.member.registMember(email, pass, phone, addr)){
            JOptionPane.showMessageDialog(null,"회원가입이 완료되었습니다. 로그인 창으로 돌아가서 로그인 해주세요.");
            cards.show(frame.getContentPane(), "login");
        }
    }

}// Register