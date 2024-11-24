package ui.tabs;

import java.awt.*;
import javax.swing.*;

public class DrawTab extends AbstractCreateTab {
    @Override
    public JPanel createTab() {
        // Create a blank panel for the "Draw" tab
        JPanel drawPanel = new JPanel();
        drawPanel.setBackground(Color.WHITE); // Set background color to white
        return drawPanel;
    }
}
