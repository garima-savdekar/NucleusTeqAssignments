
import java.util.Scanner;

public class TemperatureConversion {

    private static double celsiustofahreheit(double temp) {
        return (temp * 9 / 5) + 32;
    }

    private static double fahrenheittocelsius(double temp) {
        return (temp - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which conversion you want : \n 1.Celsius to Fahrenheit \n 2.Fahrenheit to Celsius");
        int choice = sc.nextInt();
        System.out.println("Enter the temperature: ");
        double temp = sc.nextDouble();
        double convertedtemp=0;
        if (choice == 1) {
            convertedtemp = celsiustofahreheit(temp);
        } else if (choice == 2) {
            convertedtemp = fahrenheittocelsius(temp);
        } else {
            System.out.println("Invalid choice");
        }
        System.out.printf("Converted Temperature: %.2f",convertedtemp);
    }
}
