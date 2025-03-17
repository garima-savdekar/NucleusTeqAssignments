
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println("Factorial of the given Number: " + fact);
    }
}

//Recursive approach
// import java.util.Scanner;
// public class Factorial {
//     public static long factorialrecu(int n){
//         if(n==0 || n==1){
//             return 1;
//         }
//         return n*factorialrecu(n-1);
//     }
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("Enter number: ");
//         int n=sc.nextInt();
//         long fact=factorialrecu(n);
//         System.out.println("Factorial of the given Number: "+ fact);
//     }
// }
