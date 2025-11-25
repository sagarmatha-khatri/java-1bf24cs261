package CIE;

public class Internals extends Student {
    private int[] internalMarks;

    public Internals(String usn, String name, int sem, int[] internalMarks) {
        super(usn, name, sem);
        this.internalMarks = new int[5];
        System.arraycopy(internalMarks, 0, this.internalMarks, 0, 5);
    }

    public int[] getInternalMarks() {
        int[] copy = new int[5];
        System.arraycopy(internalMarks, 0, copy, 0, 5);
        return copy;
    }

    public int getInternalMark(int idx) {
        return internalMarks[idx];
    }
}
