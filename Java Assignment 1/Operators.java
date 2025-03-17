import java.util.Scanner;
public class Operators {
     public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
    System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        //Arithmetic Operators
        System.out.println("---Arithmetic Operators---");
        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));
        System.out.println("Modulus (Remainder): " + (num1 % num2));

        //Relational Operators
        System.out.println("---Relational Operators---");
        System.out.println("Equal to: " + (num1 == num2));
        System.out.println("Not equal to: " + (num1 != num2));
        System.out.println("Greater than: " + (num1 > num2));
        System.out.println("Less than: " + (num1 < num2));
        System.out.println("Greater than equal to: " + (num1 >= num2));
        System.out.println("Less than equal to: " + (num1 <= num2));

        //Logical Operators
        System.out.println("---Logical Operators---");
        System.out.println("Logical AND: " + (num1<10 && num2>20));
        System.out.println("Logical OR: " + (num1 % 2 ==2 || num2 % 2 == 2));
        System.out.println("Logical NOT: " + (!(num1>50)));

        sc.close();
    }
}


