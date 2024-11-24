package ui.panels;

import java.awt.*;
import javax.swing.*;
import listeners.SendChatButtonListener;

public class ChatContentPanel extends AbstractContentPanel {
    public ChatContentPanel(
            JTextField modelField,
            JTextField maxTokensField,
            JTextArea systemPersonalityArea,
            JTextArea userPromptArea,
            JTextArea responseArea,
            String apiKey) {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        addLabelAndTextComponent("Model:", modelField, gbc, row++);
        addLabelAndTextComponent("System Personality:", systemPersonalityArea, gbc, row++);
        addLabelAndTextComponent("User Prompt:", userPromptArea, gbc, row++);
        addLabelAndTextComponent("Max Tokens:", maxTokensField, gbc, row++);

        // Create a send-chat listener
        SendChatButtonListener listener = new SendChatButtonListener(
                modelField, maxTokensField, systemPersonalityArea, userPromptArea, responseArea, apiKey);

        addButton("Send to OpenAI", listener, gbc, row++);
        addLabelAndTextComponent("Response:", responseArea, gbc, row++);
    }

}
