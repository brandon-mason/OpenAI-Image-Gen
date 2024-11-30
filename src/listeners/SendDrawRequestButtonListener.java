package listeners;

import apiOperations.*;
import ui.panels.GenImagePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class SendDrawRequestButtonListener implements ActionListener {
    private JComboBox<String> modelField;
    private JTextArea userPromptArea, responseArea;
    private GenImagePanel genImagePanel;
    private JButton saveImageButton;
    private JButton sendButton;
    private String apiKey;

    public SendDrawRequestButtonListener(JComboBox<String> modelField, JTextArea userPromptArea,
            JTextArea responseArea, GenImagePanel genImagePanel, JButton sendButton, JButton saveImageButton, String apiKey) {
        this.modelField = modelField;
        this.userPromptArea = userPromptArea;
        this.responseArea = responseArea;
        this.genImagePanel = genImagePanel;
        this.saveImageButton = saveImageButton;
        this.sendButton = sendButton;
        this.apiKey = apiKey;
    }

    public void sendRequest() {
        if(userPromptArea.getText().isEmpty()) {
            responseArea.setText("Prompt cannot be empty.");
            return;
        }

        genImagePanel.startLoading();
        modelField.setEnabled(false);
        sendButton.setEnabled(false);
        saveImageButton.setEnabled(false);
        userPromptArea.setEditable(false);
        userPromptArea.setFocusable(false);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                String model = (String) modelField.getSelectedItem();
                String prompt = userPromptArea.getText();

                DrawCompletions drawCompletions = new DrawCompletions(apiKey, model, prompt);
                try {
                    String responseContent = drawCompletions.execute("https://api.openai.com/v1/images/generations");
                    responseArea.setText(responseContent);
                    genImagePanel.loadImage(responseContent);
                    saveImageButton.setEnabled(true);
                } catch (Exception ex) {
                    genImagePanel.loadImage(null);
                    ex.printStackTrace();
                }
                return null;
            }

            @Override
            protected void done() {
                modelField.setEnabled(true);
                userPromptArea.setEditable(true);
                userPromptArea.setFocusable(true);
                sendButton.setEnabled(true);
            }
        };
        worker.execute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sendRequest();
    }
}
