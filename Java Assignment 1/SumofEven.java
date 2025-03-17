public class SumofEven {
    public static void main(String[] args) {
        int sum=0;
        int n=1;
        while(n<=10){
            if(n%2==0){
                sum+=n;
            }
            n++;
        }
        System.out.println("Sum of even numbers from 1 to 10 is: "+sum);
    }
    
}
