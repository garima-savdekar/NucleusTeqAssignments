
import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which pattern you want to print. \n 1. Square \n 2.Triangle");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.print("Enter size of square: ");
                int s = sc.nextInt();
                for (int i = 1; i <= s; i++) {
                    for (int j = 1; j <= s; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                System.out.print("Enter height of triangle: ");
                int h = sc.nextInt();
                for (int i = 1; i <= h; i++) {
                    for (int j = i; j < h; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j <= (2 * i - 1); j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            default:
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
