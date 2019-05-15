import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel{
    int top, left , bottom, right;
    public MyJPanel() {
        top=10;
        left=10;
        bottom=10;
        right=10;
    }

    public MyJPanel(int top,int left,int bottom,int right) {
        this.top=top;
        this.left=left;
        this.bottom=bottom;
        this.right=right;
    }

    /*바깥 여백을 주는 메소드를 오버라이딩*/
    @Override
    public Insets getInsets()
    {
        Insets in=new Insets(top,left,bottom,right);//시계 반대방향으로 마진 설정\
        return in;
    }
}///////////////////////////