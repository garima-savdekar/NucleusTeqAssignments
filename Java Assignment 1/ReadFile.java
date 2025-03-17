import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ReadFile{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter path of the file: ");
        String filepath=sc.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}


            

 