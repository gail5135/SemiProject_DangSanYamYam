import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SubMenuPanel extends JPanel{

    private Container container;
    private CardLayout cards;

    private static final long serialVersionUID = 1L;

    private JPanel itemPanel, buttonPanel = new JPanel(); //체크박스, 하단 버튼2개 배치용 패널
    private JScrollPane scrollpane;
    private JButton goToCartButton, putInCartButton;   //맨 밑의 카트담기, 결제하기 버튼
    private FoodCheckBox[] farr = new FoodCheckBox[6];   //panel의 checkbox를 접근하기 위한 배열
    private MainCenterPanel mainCenter;

    public SubMenuPanel(Container container, CardLayout cards) {
        this.container = container;
        this.mainCenter = (MainCenterPanel)container;
        this.cards = cards;

        setLayout(new BorderLayout());
        add(scrollpane = new JScrollPane(itemPanel = new JPanel()), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        scrollpane.getVerticalScrollBar().setUnitIncrement(300);
        scrollpane.getVerticalScrollBar().setUI(new CustomScrollBar());

        itemPanel.setLayout(new GridLayout(0,2));      // (n * 2) 레이아웃
        itemPanel.setBackground(Color.white);
        buttonPanel.setLayout(new GridLayout(1,2));
        putInCartButton = new JButton(new ImageIcon(getClass().getResource("images/putInCart.png")));
        goToCartButton = new JButton(new ImageIcon(getClass().getResource("images/goToCart.png")));
        buttonPanel.add(putInCartButton);
        buttonPanel.add(goToCartButton);
        putInCartButton.setBorder(null);
        goToCartButton.setBorder(null);


        for (int i = 0; i < 6; i++) {   //중앙 패널에 checkbox add
            itemPanel.add(farr[i] = new FoodCheckBox(Controller.foodSelected.allFoodList.get(i).getName(), Controller.foodSelected.allFoodList.get(i).getPrice()));
        }

        addEvent();   //이벤트 배치

        setSize(500, 600);
        setVisible(true);

    }//생성자/////////////////////////////////////////////////


    public void addEvent() {

        goToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  JPanel selectedFood = new CartPanel(container, cards);
//                container.add(selectedFood, "cart");
                Controller.flag = "cart";
                cards.show(container, "cart");
            }

        });//goToCartButton.addActionListener///////////////////////////////

        putInCartButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int count = 0;
                for(int i = 0; i < farr.length; i++)
                    if(farr[i].isChecked == true)
                        count++;
                //panel에 있는 checkbox의 check값을 전부 search


                if(count == 0) {   //선택한 상품이 0개일때
                    JOptionPane.showMessageDialog(SubMenuPanel.this, "상품을 선택하지 않았습니다");   //텍스트는 필요에 따라 변경
                }else {
                    for (int i = 0; i < farr.length; i++) {      //다시한번 전부 search
                        if (farr[i].isChecked == true) {                                             //check된 음식은
                            Controller.foodSelected.inCartList.add(new Food(farr[i].getFoodName(), farr[i].getFoodPrice()));   //카트 list에 저장
                        }
                    }
                }

                mainCenter.setCart(new CartPanel(container, cards));
                //체크목록 카트로 넘기기->메소드 구현
            }
        });//putInCartButton.addActionListener//////////////////////////////
    }//addEvent//////////////////////////////////

}