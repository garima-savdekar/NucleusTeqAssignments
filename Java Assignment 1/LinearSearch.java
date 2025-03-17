
import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the element which you want to search: ");
        int num = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (array[i] == num) {
                System.out.println("Element " + num + " is found at index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element " + num + " not found");
        }
    }
}
