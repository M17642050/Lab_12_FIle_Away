import javax.swing.JFileChooser;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
public class FileInspector{
    public static void main(String[]args){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir"),"src"));
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            Path path = chooser.getSelectedFile().toPath();
            try{
                List<String>contents = Files.readAllLines(path);
                int lineCount = 0;
                int wordCount = 0;
                int characterCount = 0;
                for(String line : contents){
                    System.out.println(line);
                    lineCount++;
                    if(!line.trim().isEmpty()){
                        wordCount += line.trim().split("\\s+").length;
                    }
                    characterCount += line.length();
                }
                System.out.println("\nSummary of the file:\nFile name: "+path.getFileName()+"\nTotal number of lines in the file: "+lineCount+"\nTotal number of words in the file: "+wordCount+"\nTotal number of characters in the file: "+characterCount);
            }
            catch(IOException e){
                System.out.println("ERROR: "+e.getMessage());
            }
        }
    }
}