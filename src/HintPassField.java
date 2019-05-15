import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;

class HintPassField extends JPasswordField implements FocusListener {

    private final String hint;
    private boolean showingHint, isPwd;
    String pwd;
    public HintPassField(final String hint) {
        super(hint);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {

        setForeground(Color.gray);
        if(this.getText().isEmpty()) {
            super.setText("");
            showingHint = false;
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(this.getText().isEmpty()) {
            setForeground(Color.gray);
            super.setText(hint);

            showingHint = true;
        }
    }

    public boolean	echoCharIsSet() {
        if(showingHint) {
            return false;
        }
        else {
            return true;
        }

    }
    @Override
    public String getText() {
        pwd=super.getText();
        return showingHint ? "" : super.getText();
    }

}