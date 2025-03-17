import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number upto which you want to print fibonacci series: ");
        int n=sc.nextInt();
        int a=0;
        int b=1;
        int next;
        System.out.print(" "+ a);
        while(b<=n){
            System.out.print(" "+ b);
            next=a+b;
            a=b;
            b=next;
        }
        sc.close();
        }
    }
    

