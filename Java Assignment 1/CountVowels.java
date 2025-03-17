import java.util.Scanner;

public class CountVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String:");
        String input = sc.nextLine();

        int count=0;
        String vowels="AEIOUaeiou";
        for(int i=0; i<input.length();i++){
            if(vowels.indexOf(input.charAt(i))!=-1){
                count++;
            }
        }
        System.out.println("Number of Vowels: "+ count);
    }
    
}
