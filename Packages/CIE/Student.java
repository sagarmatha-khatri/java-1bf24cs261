package CIE;

public class Student {
    protected String usn;
    protected String name;
    protected int sem;

    public Student(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }

    public String getUsn() { return usn; }
    public String getName() { return name; }
    public int getSem() { return sem; }

    @Override
    public String toString() {
        return "USN: " + usn + ", Name: " + name + ", Sem: " + sem;
    }
}
