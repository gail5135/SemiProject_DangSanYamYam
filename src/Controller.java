import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller {
    public static Member member = new Member();
    public static FoodCollection foodSelected = new FoodCollection();
    public static String flag = null;

    public Controller() {
        new MainFrame();
    }
}
