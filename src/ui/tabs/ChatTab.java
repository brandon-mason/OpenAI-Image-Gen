package ui.tabs;

import java.awt.*;
import javax.swing.*;

import ui.panels.ImagePanel;
import ui.panels.ChatContentPanel;

public class ChatTab extends AbstractCreateTab {
    private final JTextField modelField;
    private final JTextField maxTokensField;
    private final JTextArea systemPersonalityArea;
    private final JTextArea userPromptArea;
    private final JTextArea responseArea;
    private final String apiKey;

    public ChatTab(JTextField modelField, JTextField maxTokensField, JTextArea systemPersonalityArea,
            JTextArea userPromptArea, JTextArea responseArea, String apiKey) {
        this.modelField = modelField;
        this.maxTokensField = maxTokensField;
        this.systemPersonalityArea = systemPersonalityArea;
        this.userPromptArea = userPromptArea;
        this.responseArea = responseArea;
        this.apiKey = apiKey;
    }

    @Override
    public JPanel createTab() {
        JPanel chatPanel = new JPanel(new BorderLayout());

        // Add image panel at the top
        JPanel imagePanel = new ImagePanel();
        imagePanel.setPreferredSize(new Dimension(400, 380));
        chatPanel.add(imagePanel, BorderLayout.NORTH);

        // Add main content panel
        chatPanel.add(new ChatContentPanel(modelField, maxTokensField, systemPersonalityArea, userPromptArea,
                responseArea, apiKey), BorderLayout.CENTER);

        return chatPanel;
    }
}
