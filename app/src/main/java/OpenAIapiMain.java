import javax.swing.SwingUtilities;

import ui.OpenAIapiUI;

public class OpenAIapiMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OpenAIapiUI());
    }
}
