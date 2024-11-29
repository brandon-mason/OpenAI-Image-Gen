package ui.panels;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            // Load image from resources directory
            URL imageUrl = ClassLoader.getSystemClassLoader().getResource("resources/TeslaBugsInClassRoom.png");
            if (imageUrl == null) {
                throw new IllegalArgumentException("Image not found in resources");
            }
            Image image = new ImageIcon(imageUrl).getImage();

            // Scale image to be 2/3 the size of the width and centered.
            double scaleFactor = (2.0 / 3) * getWidth() / image.getWidth(null);
            int imageWidth = (int) (scaleFactor * image.getWidth(null));
            int imageHeight = (int) (scaleFactor * image.getHeight(null));
            // Compute the left edge to center the image
            int imageLeftEdge = (getWidth() - imageWidth) / 2;
            g.drawImage(image, imageLeftEdge, 0, imageWidth, imageHeight, this);

            // Adjust panel size to match the image height
            setPreferredSize(new Dimension(imageWidth, imageHeight));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
