package utilities;

import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import ui.panels.GenImagePanel;

public class ImageSaver implements ActionListener {
    private GenImagePanel genImagePanel;
    private BufferedImage image;
    private String imageName;

    public ImageSaver(GenImagePanel genImagePanel) {
        this.genImagePanel = genImagePanel;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ImageIcon genImage = genImagePanel.getGenImage();
            this.image = new BufferedImage(genImage.getIconWidth(), genImage.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            genImage.paintIcon(null, g, 0, 0);
            g.dispose();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save a file");
            
            if(imageName == null || imageName.isEmpty()) {
                imageName = "Generated Image";
            }
            fileChooser.setSelectedFile(new File(imageName));

            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            fileChooser.setFileFilter(filter);

            boolean showBrowser = true;
            while(showBrowser) {
                int userSelection = fileChooser.showSaveDialog(null);
                if(userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    if(!fileToSave.getAbsolutePath().endsWith(".png")) {
                        fileToSave = new File(fileToSave.getAbsolutePath() + ".png");
                    }
                    if(fileToSave.exists()) {
                        int result = JOptionPane.showConfirmDialog(null, "The file exists, overwrite?", "Existing file", JOptionPane.YES_NO_OPTION);
                        if(result == JOptionPane.NO_OPTION) {
                            continue;
                        }
                    }
                    ImageIO.write(image, "png", fileToSave);
                    showBrowser = false;
                } else {
                    showBrowser = false;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to save image.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
