import CIE.Internals;
import SEE.External;
import java.util.*;

public class FinalMarksApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of students: ");
        int n = sc.nextInt();

        Internals[] in = new Internals[n];
        External[] ex = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.next();

            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int[] im = new int[5];
            System.out.print("Enter 5 internal marks: ");
            for (int j = 0; j < 5; j++) im[j] = sc.nextInt();

            int[] em = new int[5];
            System.out.print("Enter 5 external marks: ");
            for (int j = 0; j < 5; j++) em[j] = sc.nextInt();

            in[i] = new Internals(usn, name, sem, im);
            ex[i] = new External(usn, name, sem, em);
        }

        System.out.println("\nFinal Marks:");
        for (int i = 0; i < n; i++) {
            System.out.println("\n" + in[i].getName() + " (" + in[i].getUsn() + ")");
            System.out.print("Marks: ");
            for (int j = 0; j < 5; j++) {
                System.out.print(in[i].getInternalMark(j) + ex[i].getExternalMark(j) + " ");
            }
        }

        sc.close();
    }
}
