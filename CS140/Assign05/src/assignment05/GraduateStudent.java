package assignment05;
public class GraduateStudent extends Student {
    private String undergradMajor;

    public GraduateStudent(Person self, String bNum, String undergradMajor) {
        super(self, bNum);
        this.undergradMajor = undergradMajor;
    }

    public String getUndergradMajor() {
        return undergradMajor;
    }

    @Override
    public String toString() {
        return super.toString() + " (undergrad--" + undergradMajor + ")";
    }
}