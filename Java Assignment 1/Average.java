import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] numbers=new int[n];
        System.out.println("Enter the elements of the array");
        int sum=0;
        for(int i=0;i<n;i++){
            numbers[i]=sc.nextInt();
            sum+=numbers[i];
        }
        double avg=(double)sum/n;
        System.out.println("The average of the array elements is: "+avg);
        sc.close();
    }
    
}
