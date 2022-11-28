import java.io.FileInputStream;
import java.util.Scanner;

public class ReadingFiles {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Greetings.txt"); 
            Scanner scan = new Scanner(fis);
            while (scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
            scan.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
