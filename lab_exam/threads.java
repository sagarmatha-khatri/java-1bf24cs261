class Thread1 extends Thread {
    public void run() {
        try {
            while(true) {
                System.out.println("This is the First thread");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("FirstThread interrupted");
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                if (i != 4) {
                    System.out.println("This is the Second thread");
                    Thread.sleep(1000);
                }
            }
            System.out.println("This is  Second terminated");
        } catch (InterruptedException e) {
            System.out.println("SecondThread interrupted");
        }
    }
}

class Thread3 extends Thread {
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                if (i == 2|| i==4) {
                    System.out.println("This is the Third thread");
                    Thread.sleep(2000);
                }
            }
            System.out.println("This is third terminated");
        } catch (InterruptedException e) {
            System.out.println("ThirdThread interrupted");
        }
    }
}

public class threads {
    public static void main(String[] args) {
        Thread1 ob1 = new Thread1();
        Thread2 ob2 = new Thread2();
        Thread3 ob3 = new Thread3();

        ob1.start();
        ob2.start();
        ob3.start();
    }

}







