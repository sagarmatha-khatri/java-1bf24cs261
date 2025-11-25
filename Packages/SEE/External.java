package SEE;

import CIE.Student;

public class External extends Student {
    private int[] externalMarks;

    public External(String usn, String name, int sem, int[] externalMarks) {
        super(usn, name, sem);
        this.externalMarks = new int[5];
        System.arraycopy(externalMarks, 0, this.externalMarks, 0, 5);
    }

    public int[] getExternalMarks() {
        int[] copy = new int[5];
        System.arraycopy(externalMarks, 0, copy, 0, 5);
        return copy;
    }

    public int getExternalMark(int idx) {
        return externalMarks[idx];
    }
}
