import java.util.Scanner;

class InputScanner {
    Scanner sc = new Scanner(System.in);

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }
}

abstract class Shape extends InputScanner {
    int dim1, dim2;

    public void inputDimensions(String label1, String label2) {
        dim1 = getIntInput("Enter " + label1 + ": ");
        dim2 = getIntInput("Enter " + label2 + ": ");
    }

    abstract void printArea();
}

class Rectangle extends Shape {
    void input() {
        inputDimensions("length", "breadth");
    }

    void printArea() {
        int area = dim1 * dim2;
        System.out.println("Area of Rectangle: " + area);
    }
}


class Triangle extends Shape {
    void input() {
        inputDimensions("base", "height");
    }

    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + area);
    }
}


class Circle extends Shape {
    void input() {
        dim1 = getIntInput("Enter radius: ");
        dim2 = 0; 
    }

    void printArea() {
        double area = Math.PI * dim1 * dim1;
        System.out.println("Area of Circle: " + area);
    }
}


public class lab4 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Triangle tri = new Triangle();
        Circle circ = new Circle();

        System.out.println("\n--- Rectangle ---");
        rect.input();
        rect.printArea();

        System.out.println("\n--- Triangle ---");
        tri.input();
        tri.printArea();

        System.out.println("\n--- Circle ---");
        circ.input();
        circ.printArea();
    }
}