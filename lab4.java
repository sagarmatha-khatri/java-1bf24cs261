import java.util.Scanner;

class InputScanner {
    Scanner sc = new Scanner(System.in);

    int getInt(String message) {
        System.out.print(message + ": ");
        return sc.nextInt();
    }
}

abstract class Shape extends InputScanner {
    int dim1, dim2;

    Shape(int a, int b) {
        dim1 = a;
        dim2 = b;
    }

    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    void printArea() {
        int area = dim1 * dim2;
        System.out.println("Area of Rectangle = " + area);
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }

    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle = " + area);
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0);
    }

    void printArea() {
        double area = 3.14 * dim1 * dim1;
        System.out.println("Area of Circle = " + area);
    }
}

public class lab4 {
    public static void main(String[] args) {
        InputScanner input = new InputScanner();

        int l = input.getInt("Enter length of rectangle");
        int b = input.getInt("Enter breadth of rectangle");
        Rectangle r = new Rectangle(l, b);
        r.printArea();

        int base = input.getInt("Enter base of triangle");
        int height = input.getInt("Enter height of triangle");
        Triangle t = new Triangle(base, height);
        t.printArea();

        int radius = input.getInt("Enter radius of circle");
        Circle c = new Circle(radius);
        c.printArea();
    }
}
