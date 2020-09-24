package compiler.scanner;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.File;
import java.io.FileNotFoundException;

public class DScanner {
    public static void main(String[] args) {
        ReadFile("test.dcf");
    }
    static void ReadFile(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();


        }

    }


}

