
class Student {

    private String name;
    private int rollno;
    private double marks;

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    public double getMarks() {
        return marks;
    }

    public Student(String name, int rollno, double marks) {
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollno);
        System.out.println("Marks: " + marks);
    }
    public String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else {
            return "C";
        }
    }
}

class GraduateStudent extends Student{
    public String degree;
    public String specialization;
    public String projectTitle;

    public GraduateStudent(String name, int rollno, double marks, String degree, String specialization,String projectTitle) {
        super(name, rollno, marks);
        this.degree = degree;
        this.specialization = specialization;
        this.projectTitle=projectTitle;
    }
    public String getDegree() {
        return degree;
    }
    public String getSpecialization() {
        return specialization;
    }
    public String getProjectTitle() {
        return projectTitle;
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Degree: " + degree);
        System.out.println("Specialization: " + specialization);
    }
    public String calculateGrade(boolean projectTitle) {
        if (projectTitle) {
            double marks = getMarks();
            return (marks >= 85) ? "A+" : "B+";
        } else {
            return super.calculateGrade();
        }
    }
}

public class Oops{
    public static void main(String[] args) {
        Student student1 = new Student("John", 105, 85);
        GraduateStudent gradStud1 = new GraduateStudent("Bob", 103, 90, "BTech", "Computer Science","AI in Health");

        System.out.println("Displaying Student Information:");
        student1.displayDetails();

        System.out.println("Displaying Graduate Student Information:");
        gradStud1.displayDetails();

        String gradstuwithoutproject=gradStud1.calculateGrade();
        String gradstuwithproject=gradStud1.calculateGrade(true);
        System.out.println("Graduate Student Grade without project: "+gradstuwithoutproject);
        System.out.println("Graduate Student Grade with project: "+gradstuwithproject);
    }
}

//Encapsulation:Binding data attributes and methods into a single unit.
//Hide internal details of an object from outside world.
//In above example marks variable in Student class is encapsulated within the class.
//To access marks from extended class getter method is used.
