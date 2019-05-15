import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CartPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel centerPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel pricePanel = new JPanel();
    private JPanel pricePanel_sub = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private JLabel messageLabel = new JLabel("총 결제금액", SwingConstants.CENTER);
    private JLabel priceLabel = new JLabel("", SwingConstants.RIGHT);

    private JButton cancelButton, payButton;      //버튼 2개
    private int totalPrice;      //가격 정보
    private JScrollPane scrollpane;

    private Container container;
    private CardLayout cards;

    private MainCenterPanel mainCenter;

    public CartPanel(Container container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
        this.mainCenter = (MainCenterPanel)container;

        setLayout(new BorderLayout());
        add(scrollpane = new JScrollPane(centerPanel), BorderLayout.CENTER);
        scrollpane.getVerticalScrollBar().setUnitIncrement(300);
        scrollpane.getVerticalScrollBar().setUI(new CustomScrollBar());
        add(bottomPanel, BorderLayout.SOUTH);

        int temp = Controller.foodSelected.inCartList.size();
        if(temp < 5) {
            centerPanel.setLayout(new GridLayout(5, 1, 0, 0));

        }else{
            centerPanel.setLayout(new GridLayout(Controller.foodSelected.inCartList.size(), 1, 0, 0));
        }

        bottomPanel.setLayout(new BorderLayout(0, 10));
        centerPanel.setBackground(Color.white);
        bottomPanel.setBackground(Color.WHITE);
        pricePanel.setBackground(Color.white);
        pricePanel_sub.setBackground(Color.white);

        bottomPanel.add(pricePanel, BorderLayout.CENTER);
        pricePanel.setLayout(new BorderLayout());
        pricePanel.add(messageLabel, BorderLayout.CENTER);   //레이블 붙는 위치
        pricePanel.add(pricePanel_sub, BorderLayout.SOUTH);
        pricePanel_sub.setLayout(new GridLayout(1, 2, 10, 0));

        pricePanel_sub.add(priceLabel);
        pricePanel_sub.add(new JLabel("원", SwingConstants.LEFT));

        for(int i = 0; i < Controller.foodSelected.inCartList.size(); i++){
            JLabel food = new JLabel(new ImageIcon(getClass().getResource("images/food/" + Controller.foodSelected.inCartList.get(i).getName() + "_inCart.png")));
            centerPanel.add(food);
        }

        priceLabel.setText(totalPrice+"");
        priceLabel.setText(String.valueOf(totalPrice = FoodCollection.calculateSum(Controller.foodSelected.inCartList)));   //주석 제거해서 사용하는 코드
        messageLabel.setFont(new Font("돋움", Font.BOLD, 30));
        priceLabel.setFont(new Font("돋움", Font.ITALIC, 20));

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(cancelButton = new JButton(new ImageIcon(getClass().getResource("images/cancel.png"))));
        buttonPanel.add(payButton = new JButton(new ImageIcon(getClass().getResource("images/pay.png"))));
        payButton.setBorder(null);
        cancelButton.setBorder(null);
        //버튼 배치

        addEvent();   //두 버튼을 클릭했을때 발생하는 이벤트 add

        setVisible(true);
        setSize(500,600);
    }

    public void addEvent() {
        cancelButton.addActionListener(new ActionListener() {   //취소버튼 event

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(CartPanel.this, "취소 하시겠습니까?", "", JOptionPane.YES_NO_OPTION);
                //알림창 띄우기

                if (result == JOptionPane.YES_OPTION) {
                    cards.show(container, "sub");
                } else {
                    //취소 결정 창에서 취소했을 경우(아무 작업도 하지 않을 것으로 예상)
                }
            }

        });
        payButton.addActionListener(new ActionListener() {      //결제버튼 event

            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(CartPanel.this, "결제 하시겠습니까?", "", JOptionPane.YES_NO_OPTION);
                //알림창 띄우기

                if (result == JOptionPane.YES_OPTION) {
                    Controller.foodSelected.setEmptyInCartList();
                    cards.removeLayoutComponent(mainCenter.getCart());
                    mainCenter.setCart(new CartPanel(mainCenter, cards));
                    JOptionPane.showMessageDialog(CartPanel.this,"결제가 완료되었습니다!!");
                    cards.show(container, "main");
                } else {
                    //결제 결정 창에서 취소했을 경우(아무 작업도 하지 않을 것으로 예상)
                }
            }
        });
    }
}
