
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

class HintTextField extends JTextField implements FocusListener {

    private final String hint;
    private boolean showingHint;

    public boolean isShowingHint() {
        return showingHint;
    }

    public void setShowingHint(boolean showingHint) {
        this.showingHint = showingHint;
    }

    public HintTextField(final String hint) {
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
    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }

}

