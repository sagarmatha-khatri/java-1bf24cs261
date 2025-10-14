import java.util.Scanner;

class Subject {
    int subjectMarks, credits, grade;
}

class lab_2 {
    String name, usn;
    double CGPA;
    Scanner sc = new Scanner(System.in);
    Subject subject[];

    lab_2(String n, String u, double c) {
        this.name = n;
        this.usn = u;
        this.CGPA = c;
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
    }

    void getSGPA() {
        int effectiveScore = 0, totalCredits = 0;
        for (int i = 0; i < 8; i++) {
            effectiveScore += (subject[i].grade * subject[i].credits);
            totalCredits += subject[i].credits;
        }
        double SGPA = (double) effectiveScore / (double) totalCredits;
        System.out.println("SGPA: " + SGPA);
    }

    public static void main(String[] args) {
        lab_2 obj = new lab_2("", "", 0);
        obj.getStudentDetails();
        obj.getMarks();
        obj.getSGPA();
    }
}