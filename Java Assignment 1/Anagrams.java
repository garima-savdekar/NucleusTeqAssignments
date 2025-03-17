import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {
    public static boolean anagramstrings(String first,String second) {
        first=first.replaceAll("\\s","").toLowerCase();
        second=second.replaceAll("\\s","").toLowerCase();
        
        if(first.length()!=second.length()){
            return false;
        }
        HashMap<Character,Integer> freq=new HashMap<>();
        for(char c:first.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        for(char c:second.toCharArray()){
            if(!freq.containsKey(c)){
               return false;
            }
            freq.put(c,freq.get(c)-1);
            if(freq.get(c)==0){
                freq.remove(c);
            }
        }
            return freq.isEmpty();
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First String:");
        String first = sc.nextLine();
        System.out.println("Enter Second String:");
        String second = sc.nextLine();
        
        if(anagramstrings(first,second)){
            System.out.println("Anagram String");
        }
        else{
           System.out.println("Not Anagrams");
        }
    }
}
