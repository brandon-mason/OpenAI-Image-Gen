package ui.tabs;

import javax.swing.*;
import utilities.TextAreaMaker;

public class ChatTabComponents {
    private JTextField modelField;
    private JTextField maxTokensField;
    private JTextArea systemPersonalityArea;
    private JTextArea userPromptArea;
    private JTextArea responseArea;

    public ChatTabComponents() {
        // Initialize shared components
        modelField = new JTextField("gpt-4o", 20);
        maxTokensField = new JTextField("200", 10);
        systemPersonalityArea = TextAreaMaker.createWrappedTextArea("I am a 10 year old who uses Gen Z slang", 2, 30);
        userPromptArea = TextAreaMaker.createWrappedTextArea(
                "Why is the object oriented programming course at Texas State University so good despite being taught by a grumpy old guy?",
                3, 30);
        responseArea = TextAreaMaker.createWrappedTextArea("", 8, 40);
        responseArea.setEditable(false);
    }

    public JTextField getModelField() {
        return modelField;
    }

    public JTextField getMaxTokensField() {
        return maxTokensField;
    }

    public JTextArea getSystemPersonalityArea() {
        return systemPersonalityArea;
    }

    public JTextArea getUserPromptArea() {
        return userPromptArea;
    }

    public JTextArea getResponseArea() {
        return responseArea;
    }
}
