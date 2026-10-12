import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
public class DataSaver{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String>list = new ArrayList<>();
        boolean loop = true;
        do {
            boolean userChoice = SafeInput.getYNConfirm(in, "Do you have data to input?(Y/n): ");
            if(userChoice){
                String fName = SafeInput.getNonZeroLenString(in, "Enter your first name");
                String lName = SafeInput.getNonZeroLenString(in, "Enter your last name");
                String id = SafeInput.getRegExString(in, "Enter your six-digit ID number: ", "^\\d{6}$");
                String email = SafeInput.getRegExString(in, "Enter your email address: ", "^[A-Za-z0-9_.-]+@[A-Za-z0-9_.-]+$");
                String year = SafeInput.getRegExString(in, "Enter your four-digit year of birth: ", "^\\d{4}$");
                list.add(fName+", "+lName+", "+id+", "+email+", "+year);
            }
            else{
                loop = false;
                String fileName = SafeInput.getNonZeroLenString(in, "What should be the name of the file in which to store your data?");
                Path path = Path.of("/home/rudra-prajapati/IdeaProjects/Lab_12_FIle_Away/src/"+fileName+".csv");
                try{
                    Files.write(path,list);
                }
                catch (IOException e) {
                    System.out.println("ERROR: "+e.getMessage());
                }
            }
        }
        while(loop);
    }
}