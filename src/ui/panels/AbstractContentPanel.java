package ui.panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class AbstractContentPanel extends JPanel {
    public AbstractContentPanel() {
        super(new GridBagLayout());
    }

    protected void addLabelAndTextComponent(String labelText, JComponent component, GridBagConstraints gbc, int row) {
        // Add the label
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel(labelText), gbc);

        // Add the component
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(component, gbc);
    }

    /**
     * Creates a JButton, assigns its listener, and adds it to the panel using the
     * provided GridBagConstraints.
     *
     * @param buttonText The text for the button
     * @param listener   The ActionListener to attach to the button
     * @param gbc        The GridBagConstraints for layout
     * @param row        The row to place the button in
     */
    protected void addButton(String buttonText, ActionListener listener, GridBagConstraints gbc, int row) {
        JButton button = new JButton(buttonText);
        button.addActionListener(listener);

        // Set GridBagConstraints properties for the button
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add button to the panel
        add(button, gbc);
    }
}
