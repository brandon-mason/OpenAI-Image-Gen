package utilities;

import javax.swing.*;
import java.awt.*;

public class TextAreaMaker {
    public static JTextArea createWrappedTextArea(String text, int rows, int columns) {
        JTextArea textArea = new JTextArea(text, rows, columns);
        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries
        textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Optional: add a border
        return textArea;
    }
}
