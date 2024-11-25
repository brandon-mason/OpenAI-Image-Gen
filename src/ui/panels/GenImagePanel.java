package ui.panels;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;

public class GenImagePanel extends JPanel {
    private Image image;
    
    public void loadImage(String imageUrl) {
        try {
            Image image = ImageIO.read(new URL(imageUrl));
            if(image == null) {
                throw new MalformedURLException("URL does not point to an image.");
            }
            this.image = image;
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
