package ui.misc;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileBrowser extends JFileChooser {
    private File selectedFile;
    private String imageName;
    private int option = 0;

    public FileBrowser()  {
        setDialogTitle("Save a file");

        if(imageName == null || imageName.isEmpty()) {
            imageName = "Generated Image";
        }
        setSelectedFile(new File(imageName));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
        setFileFilter(filter);

        boolean showBrowser = true;
        while(showBrowser) {
            int userSelection = showSaveDialog(null);
            if(userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = super.getSelectedFile();
                if(!fileToSave.getAbsolutePath().endsWith(".png")) {
                    setSelectedFile(new File(fileToSave.getAbsolutePath() + ".png"));
                }
                if(fileToSave.exists()) {
                    int result = JOptionPane.showConfirmDialog(null, "The file exists, overwrite?", "Existing file", JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.NO_OPTION) {
                        continue;
                    }
                }
                showBrowser = false;
            } else {
                showBrowser = false;
            }
        }
    }

    public File getFileToSave() {
        return selectedFile;
    }
}
