import java.util.Scanner;

public class go3 {
    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double a = inputs.nextDouble();

        System.out.println("Enter the second number:");
        double b = inputs.nextDouble();

        System.out.println("Enter the third number:");
        double c = inputs.nextDouble();

        if (a > b && a > c) {
            System.out.println("A is the greatest: " + a);
        } else if (b > c && b > a) {
            System.out.println("B is the greatest: " + b);
        } else {
            System.out.println("C is the greatest: " + c);
        }
    }
}
