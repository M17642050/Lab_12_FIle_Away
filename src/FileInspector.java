import javax.swing.JFileChooser;
import java.io.File;
public class FileInspector{
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        } else {
            System.out.println("No file selected.");
        }
    }
}