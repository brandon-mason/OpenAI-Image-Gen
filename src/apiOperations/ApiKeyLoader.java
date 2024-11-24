package apiOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class ApiKeyLoader {
    public static String loadApiKey() {
        String apiKey = null;
        String currentPath = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentPath);

        try (FileReader fr = new FileReader(".env")) {
            System.out.println("FileReader is: " + fr);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("API_KEY=")) {
                    String quotedApiKey = line.substring("API_KEY=".length());
                    apiKey = quotedApiKey.replaceAll("'", "");
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load API key from .env file.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return apiKey;
    }
}
