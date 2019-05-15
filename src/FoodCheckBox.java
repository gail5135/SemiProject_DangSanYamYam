import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FoodCheckBox extends JCheckBox {

    private static final long serialVersionUID = 1L;

    private JPanel bottomPanel;
    private JCheckBox cb;
    private String foodName;
    private int foodPrice;
    public boolean isChecked;      //아이템 선택 상태를 저장하는 필드 -> 외부에서 접근하기 위한 용도

    public FoodCheckBox(String foodName, int foodPrice) {
        this.setIcon(new ImageIcon(getClass().getResource("images/food/" + foodName + ".png")));
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.setBorder(null);
        this.setPreferredSize(new Dimension(240,220));


//        add(bottomPanel = new JPanel(), BorderLayout.SOUTH);
//        bottomPanel.setLayout(new BorderLayout());
//        bottomPanel.setBackground(Color.white);


        this.addItemListener(new ItemListener() {      //체크박스 클릭했을 때 발생하는 event

            @Override
            public void itemStateChanged(ItemEvent e) {   //아이템 상태 변경시 발생하는 event
                if (e.getStateChange() == ItemEvent.SELECTED) {      //아이템이 선택되었을 때
                    setIcon(new ImageIcon(getClass().getResource("images/food/" + foodName + "_checked.png")));
                    isChecked = true;

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {   //아이템이 선택되지 않았을 때
                    setIcon(new ImageIcon(getClass().getResource("images/food/" + foodName + ".png")));
                    isChecked = false;
                }
            }
        });
    }//생성자//////////////////////////////////////////////////////////


    public String getFoodName() {
        return foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }
}