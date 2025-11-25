import java.util.*;


class InputScanner {
    Scanner sc;

    InputScanner() {
        sc = new Scanner(System.in);
    }

    int getInt() {
        return sc.nextInt();
    }
}

class WrongAge extends Exception{
    public WrongAge(String message){
        super(message);
    }
}


class father extends InputScanner {
    int fatherAge;

    father() throws WrongAge {
        System.out.print("Enter Father's Age: ");
        fatherAge = getInt();

        if (fatherAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
    }

    void display() {
        System.out.println("Father's Age: " + fatherAge);
    }
}




class Son extends father {
    int sonAge;
    
    Son() throws WrongAge {
        super(); 

        System.out.print("Enter Son's Age: ");
        sonAge = getInt();

        if (sonAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
        int gap= fatherAge-sonAge;
        if (gap<=18){
            throw new WrongAge("Impossible age difference");
        }

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to father's age");
        }
    }

    void display() {
        super.display(); 
        System.out.println("Son's Age is: " + sonAge);
    }
}




public class lab7 {
        public static void main(String[] args) {
        try {
            Son s = new Son();
            s.display();

        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
