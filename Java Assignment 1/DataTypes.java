//Primitive Data types are predefined in Java and they store actual values.
//These are of fixed size and directly stored in stack.
//Example: int,float,double,boolean etc.
//Reference Data Types: Objects or instances created from classes.Stores references to the actual data in the memory and created by programmers.
//Size varies depending on the object and stored in heap while references stored in stack.
//Example: Objects,Arrays,Strings etc.

import java.util.ArrayList;
import java.util.Arrays;

public class DataTypes {
    public static void main(String[] args) {
        //Primitive Data Type
        int number=90;
        double num=56.25;
        boolean flag=true;
        char letter='M';
        System.out.println("Primitive Data Types");
        System.out.println("Number of Integer type: "+number);
        System.out.println("Number of double type"+num);
        System.out.println("Boolean type: "+flag);
        System.out.println("Character Type: "+letter);
        
        String str="Hello";
        int [] array={2,6,5,8,9};
        ArrayList<String> fruits=new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");

        System.out.println("Reference Data Types");
        System.out.println("String type: "+str);
        System.out.println("Arrays: "+Arrays.toString(array));
        System.out.println("ArrayList: "+fruits);
    }
}
