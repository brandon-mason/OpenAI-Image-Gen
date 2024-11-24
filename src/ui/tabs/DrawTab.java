package ui.tabs;

import java.awt.*;
import javax.swing.*;

import ui.panels.DrawContentPanel;

public class DrawTab extends AbstractCreateTab {
    private final JComboBox<String> modelComboBox;
    private final JTextArea promptArea;
    private final JTextArea responseArea;
    public final String apiKey;

    public DrawTab(JComboBox<String> modelComboBox, JTextArea promptArea, JTextArea responseArea, String apiKey) {
        this.modelComboBox = modelComboBox;
        this.promptArea = promptArea;
        this.responseArea = responseArea;
        this.apiKey = apiKey;
    }

    @Override
    public JPanel createTab() {
        JPanel drawPanel = new JPanel();
        drawPanel.add(new DrawContentPanel(modelComboBox, promptArea, responseArea, apiKey));
        return drawPanel;
    }
}
