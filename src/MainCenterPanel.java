import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MainCenterPanel extends JPanel {
    private CardLayout cards;
    private MainMenuPanel mainMenu;
    private JPanel subMenu;
    private CartPanel cart;
    private JPanel search;
    private FoodCollection foodSelected;

    public MainCenterPanel() {
        Controller.flag = "main";
        cards = new CardLayout();
        foodSelected = new FoodCollection();

        mainMenu = new MainMenuPanel(this, cards);
        //subMenu = new SubMenuPanel(this, cards, selectedFood);
        cart = new CartPanel(this, cards);
        search = new SearchPanel(this, cards);

        this.setPreferredSize(new Dimension(500,667));
        this.setLayout(cards);

        this.add(mainMenu, "main");
        //this.add(subMenu, "sub");
        this.add(cart, "cart");
        this.add(search, "search");

    }

    public void setCart(CartPanel carts){
        this.cart = carts;
        if(cart != null) {
            this.add(cart, "cart");
        }
    }

    public void setSubMenu(SubMenuPanel sub){
        this.subMenu = sub;
        if(subMenu != null) {
            this.add(subMenu, "sub");
        }
    }

    public CartPanel getCart(){
        return cart;
    }

}
