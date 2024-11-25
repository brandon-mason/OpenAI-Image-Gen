package ui.tabs;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import ui.panels.GenImagePanel;
import utilities.TextAreaMaker;

public class DrawTabComponents {
    private JComboBox<String> modelComboBox;
    private JTextArea promptArea;
    private JTextArea responseArea;
    private GenImagePanel genImagePanel;

    public DrawTabComponents() {
        // Initialize shared components
        modelComboBox = new JComboBox<>(new String[] { "dall-e-2", "dall-e-3" });
        modelComboBox.setSelectedIndex(1);
        promptArea = TextAreaMaker.createWrappedTextArea(
                "A cat holding a bat wearing a hat while sitting on a mat",
                3, 30);
        responseArea = TextAreaMaker.createWrappedTextArea("", 8, 40);
        responseArea.setEditable(false);
        genImagePanel = new GenImagePanel();
    }

    public JComboBox<String> getModelComboBox() {
        return modelComboBox;
    }

    public JTextArea getPromptArea() {
        return promptArea;
    }

    public JTextArea getResponseArea() {
        return responseArea;
    }

    public GenImagePanel getGenImagePanel() {
        return genImagePanel;
    }
}
