package gui;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class TextBox extends JTextField {

    public TextBox(int preferredSize) {
        super();
        setPreferredSize(new Dimension(preferredSize, preferredSize));
        setHorizontalAlignment(JTextField.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));


        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 20);
        setFont(timesNewRoman);

        // Apply document filter to restrict input to one character
        AbstractDocument doc = (AbstractDocument) getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() > 1) {
                    return; // Prevent insertion if more than one character
                }
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text != null && fb.getDocument().getLength() + text.length() > 1) {
                    return; // Prevent replacement if more than one character
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
    }

}
