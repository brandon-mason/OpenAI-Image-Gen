package listeners;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class TextAreaDocumentListener implements DocumentListener {
    SendDrawRequestButtonListener listener;
    JTextArea promptArea;

    public TextAreaDocumentListener(SendDrawRequestButtonListener listener, JTextArea promptArea) {
        super();
        this.listener = listener;
        this.promptArea = promptArea;
    }
 
    // Used on JTextArea as a substitute for an ActionListener.
    // This method checks after each key press if the user has created a newline,
    // and if so, it triggers the action listener of this.listener.
    public void insertUpdate(DocumentEvent e) {
        Document doc = (Document) e.getDocument();
        
        try {
            String docText = doc.getText(0, doc.getLength());
            if(docText.endsWith("\n") && !docText.isEmpty()) {
                listener.sendRequest();
                promptArea.setText(docText.substring(0, docText.length() - 1));
            }
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // No implementation needed
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // No implementation needed
    }
}
