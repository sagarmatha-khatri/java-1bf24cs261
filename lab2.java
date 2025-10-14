import java.util.Scanner;

class Subject {
    int subjectMarks, credits, grade;
}

class lab2 {
    String name, usn;
    double SGPA;
    Scanner sc = new Scanner(System.in);
    Subject[] subject;

    lab2() {
        subject = new Subject[8];
        for (int i = 0; i < 8; i++) {
            subject[i] = new Subject();
        }
    }

    void getStudentDetails() {
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
    }

    void getMarks() {
        for (int i = 0; i < 8; i++) {
            System.out.print("Enter Marks for Subject " + (i + 1) + ": ");
            subject[i].subjectMarks = sc.nextInt();
            System.out.print("Enter Credits for Subject " + (i + 1) + ": ");
            subject[i].credits = sc.nextInt();

            subject[i].grade = (subject[i].subjectMarks / 10) + 1;
            if (subject[i].grade == 11)
                subject[i].grade = 10;
            if (subject[i].grade <= 4)
                subject[i].grade = 0;
        }
        sc.nextLine(); // consume leftover newline
    }

    void calculateSGPA() {
        int effectiveScore = 0, totalCredits = 0;
        for (int i = 0; i < 8; i++) {
            effectiveScore += (subject[i].grade * subject[i].credits);
            totalCredits += subject[i].credits;
        }
        SGPA = (double) effectiveScore / (double) totalCredits;
    }

    void displayStudentInfo() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        System.out.println("SGPA: " + SGPA);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lab2[] students = new lab2[2]; // for 2 students

        for (int i = 0; i < 2; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ": ");
            students[i] = new lab2();
            students[i].getStudentDetails();
            students[i].getMarks();
            students[i].calculateSGPA();
            System.out.println("Results: ");
            students[i].displayStudentInfo();
        }

       
    
    }
}