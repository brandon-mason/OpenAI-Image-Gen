package ui.panels;

import java.awt.*;

import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;

public class GenImagePanel extends JPanel {
    private ImageIcon genImage;

    public void startLoading() {
        try {
            // Load gif from resources directory
            URL loaderUrl = ClassLoader.getSystemClassLoader().getResource("resources/Loader.gif");
            if (loaderUrl == null) {
                throw new IllegalArgumentException("Gif not found in resources");
            }
            this.genImage = new ImageIcon(loaderUrl);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadImage(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            this.genImage = new ImageIcon(url);
            repaint();
        } catch (MalformedURLException e) {
            this.genImage = null;
        }
    }

    public ImageIcon getGenImage() {
        return genImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (genImage != null) {
            g.drawImage(genImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }
}
