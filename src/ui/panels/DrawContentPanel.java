package ui.panels;

import java.awt.*;
import javax.swing.*;
import listeners.SendDrawRequestButtonListener;

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
        saveImageButton.setEnabled(false);
        SendDrawRequestButtonListener listener = new SendDrawRequestButtonListener(
                modelComboBox, promptArea, responseArea, genImagePanel, saveImageButton, apiKey);

        addButton("Send to OpenAI", listener, gbc, row++);
        addLabelAndTextComponent("Response:", responseArea, gbc, row++);

        // Add image panel for generated images
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        genImagePanel.setPreferredSize(new Dimension(525, 525));
        add(genImagePanel, gbc);
        
        gbc.gridy = row++;
        add(saveImageButton, gbc);
    }
}
