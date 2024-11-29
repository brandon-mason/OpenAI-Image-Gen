package ui.panels;

import java.awt.*;
import javax.swing.*;

import listeners.SendDrawRequestButtonListener;
import utilities.ImageSaver;

public class DrawContentPanel extends AbstractContentPanel {
    public DrawContentPanel(
            JComboBox<String> modelComboBox, 
            JTextArea promptArea,
            JTextArea responseArea,
            GenImagePanel genImagePanel,
            String apiKey) {
                
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Model:"), gbc);

        // Add the component
        gbc.gridx = 1;
        gbc.gridy = row++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(modelComboBox, gbc);

        addLabelAndTextComponent("Prompt:", promptArea, gbc, row++);
        
        JButton saveImageButton = new JButton("Save Image");
        JButton sendButton = new JButton("Send to OpenAI");
        saveImageButton.setEnabled(false);
        sendButton.setEnabled(true);
        
        SendDrawRequestButtonListener listener = new SendDrawRequestButtonListener(
                modelComboBox, promptArea, responseArea, genImagePanel, sendButton, saveImageButton, apiKey);
        sendButton.addActionListener(listener);

                modelComboBox, promptArea, responseArea, genImagePanel, saveImageButton, apiKey);

        gbc.gridy = row++;
        add(sendButton, gbc);

        addLabelAndTextComponent("Response:", responseArea, gbc, row++);
        responseArea.setFocusable(false);

        // Add image panel for generated images
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        genImagePanel.setPreferredSize(new Dimension(525, 525));
        add(genImagePanel, gbc);

        ImageSaver imageSaver = new ImageSaver(genImagePanel);
        saveImageButton.addActionListener(imageSaver);
        
        gbc.gridy = row++;
        add(saveImageButton, gbc);
    }
}
