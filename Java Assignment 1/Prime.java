import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number:");
        int n=sc.nextInt();
        boolean isprime=true;
        if(n==1){
            System.out.println("1 is neither prima nor composite");
        }
        else{
            for(int i=2;i<=n/2;i++){
                if(n%i==0){
                    isprime=false;
                    break;
                }
            }
        }
        if(isprime){
            System.out.println(n + " is prime number");
        }
        else{
            System.out.println(n + " is not a prime number");
        }
        sc.close();
    }
    
}
