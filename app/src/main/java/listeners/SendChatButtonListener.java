package listeners;

import apiOperations.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendChatButtonListener implements ActionListener {
    private JTextField modelField, maxTokensField;
    private JTextArea systemPersonalityArea, userPromptArea, responseArea;
    private String apiKey;

    public SendChatButtonListener(JTextField modelField, JTextField maxTokensField,
            JTextArea systemPersonalityArea, JTextArea userPromptArea,
            JTextArea responseArea, String apiKey) {
        this.modelField = modelField;
        this.maxTokensField = maxTokensField;
        this.systemPersonalityArea = systemPersonalityArea;
        this.userPromptArea = userPromptArea;
        this.responseArea = responseArea;
        this.apiKey = apiKey;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gptModel = modelField.getText();
        String systemPersonality = systemPersonalityArea.getText();
        String userPrompt = userPromptArea.getText();
        int maxTokens = Integer.parseInt(maxTokensField.getText());

        ChatCompletions chatCompletions = new ChatCompletions(apiKey, gptModel, systemPersonality, userPrompt,
                maxTokens);
        try {
            String responseContent = chatCompletions.execute("https://api.openai.com/v1/chat/completions");
            responseArea.setText(responseContent);
        } catch (Exception ex) {
            responseArea.setText("OpenAI chat response error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
