package ui.tabs;

import javax.swing.*;

import ui.panels.DrawContentPanel;
import ui.panels.GenImagePanel;

public class DrawTab extends AbstractCreateTab {
    private final JComboBox<String> modelComboBox;
    private final JTextArea promptArea;
    private final JTextArea responseArea;
    private final GenImagePanel genImagePanel;
    public final String apiKey;

    public DrawTab(JComboBox<String> modelComboBox, JTextArea promptArea, JTextArea responseArea, GenImagePanel genImagePanel, String apiKey) {
        this.modelComboBox = modelComboBox;
        this.promptArea = promptArea;
        this.responseArea = responseArea;
        this.genImagePanel = genImagePanel;
        this.apiKey = apiKey;
    }

    @Override
    public JPanel createTab() {
        JPanel drawPanel = new JPanel();
        drawPanel.add(new DrawContentPanel(modelComboBox, promptArea, responseArea, genImagePanel, apiKey));
       
        return drawPanel;
    }
}
