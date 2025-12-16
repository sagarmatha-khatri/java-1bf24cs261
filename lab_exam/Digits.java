import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a 5-digit number:");
        int number = input.nextInt();

        int sum = 0;

        while (number > 0) {
            int digit = number % 10;  
            sum += digit;             
            number /= 10;
        }

        System.out.println("Sum of digits = " + sum);
    }
}
