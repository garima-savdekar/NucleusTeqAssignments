import java.util.Scanner;
public class Area{

    public static double calcareaofcircle(double radius){
        return Math.PI*radius*radius;
    }

    public static double calcareaofrect(double length,double width){
        return length*width;
    }

    public static double calcareaoftri(double base,double height){
        return 0.5*base*height;
    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Choose shape to calculate area");
    System.out.println("1. Circle");
    System.out.println("2. Rectangle");
    System.out.println("3. Triangle");

    System.out.println("Choose number which you want: ");
    int n=sc.nextInt();

    switch (n){
        case 1:
            System.out.println("Enter radius of Circle: ");
            double r=sc.nextDouble();
            double areaofcircle=calcareaofcircle(r);
                        System.out.printf("Area of Circle: %.2f ", areaofcircle);
                        break;
            
                    case 2:
                        System.out.println("Enter length and width of rectangle: ");
                        double l=sc.nextDouble();
                        double w=sc.nextDouble();
                        double areaofrect=calcareaofrect(l,w);
                        System.out.printf("Area of Rectangle: %.2f ", areaofrect);
                        break;
            
                    case 3:
                        System.out.println("Enter base and height of Triangle: ");
                        double b=sc.nextDouble();
                        double h=sc.nextDouble();
                        double areaoftri=calcareaoftri(b,h);
                        System.out.printf("Area of Triangle: %.2f ", areaoftri);
                        break;
            
                    default:
                        System.out.println("Enter valid number from 1, 2 and 3 ");
                }
            
    sc.close();
           
    }
}