import java.util.Scanner;

public class LargestNo {
    public static void main(String[] args) {
        int n1,n2,n3;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter three numbers:");
        n1=sc.nextInt();
        n2=sc.nextInt();
        n3=sc.nextInt();
        int largest;
        if(n1>n2 && n1>n3){
            largest=n1;
        }
        else if(n2>n1 && n2>n3){
            largest=n2;
        }
        else{
           largest=n3;
        }
        System.out.println("Largest Number is "+ largest);
    }
}
