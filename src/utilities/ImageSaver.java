package utilities;

import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ui.misc.FileBrowser;
import ui.panels.GenImagePanel;

public class ImageSaver implements ActionListener {
    private GenImagePanel genImagePanel;
    private BufferedImage image;

    public ImageSaver(GenImagePanel genImagePanel) {
        this.genImagePanel = genImagePanel;
    }

    public void writeImage(File imageFile) {
        try {
            ImageIO.write(image, "png", imageFile);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to save image.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon genImage = genImagePanel.getGenImage();
        this.image = new BufferedImage(genImage.getIconWidth(), genImage.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        genImage.paintIcon(null, g, 0, 0);
        g.dispose();
        new FileBrowser(this);
    }
}
