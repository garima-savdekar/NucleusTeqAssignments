// Abstract Class
abstract class Shape {
    String objectName = " ";

    Shape(String name) {
        this.objectName = name;
   }
    abstract public double area();
    public void draw(){
        System.out.println("Shape has been drawn ");
    }
}

class Rectangle extends Shape {
    int length, width;

    Rectangle(int length, int width, String name) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override 
    public double area() {
        return (double)(length * width);
    }
}

class Circle extends Shape {
    double pi = 3.14;
    int radius;

    Circle(int radius, String name) {
        super(name);
        this.radius = radius;
    }

    @Override 
    public double area() {
        return (double)(pi * radius * radius);
    }
}

// Interface
interface Vehicle {
    void wheel();
    void brand();
}

class Car implements Vehicle {
    private String model;

    public Car(String model) {
        this.model = "";
    }
    @Override
    public void wheel() {
         System.out.println("Four Wheeler");
    }

    @Override
    public void brand() {
        System.out.println("Honda");
    }
}

public class AbstractandInterface{
    public static void main(String[] args) {
        
        Car car = new Car("Honda");
        car.wheel();
        car.brand();
        Shape rect = new Rectangle(2, 3, "Rectangle");
        System.out.println("Area of rectangle: " + rect.area());
        rect.draw();

        System.out.println();

        Shape circle = new Circle(2, "Circle");
        System.out.println("Area of circle: " + circle.area());
        circle.draw();
    }
}


//Abstract Class cannot be instantiated,contains both abstract and concrete methods.
//Class can inherit from only one abstract class.

//Interface specifies a set of methods which class must implement,methods are abstract by deafult.
//Class can implement multiple interfaces.