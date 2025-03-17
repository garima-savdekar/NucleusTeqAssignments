
import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String to reverse:");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);
        StringBuilder reversed = sb.reverse();
        System.out.println("Reversed String: " + reversed);
    }
}
