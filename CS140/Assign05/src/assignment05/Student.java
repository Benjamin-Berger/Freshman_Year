package assignment05;
public class Student implements Comparable<Student> {
    private Person self;
    private String bNumber;
    private String major;

    public Student(Person self, String bNum) {
        this.self = self;
        bNumber = bNum;
    }

    public Person getSelf() {
        return self;
    }

    public String getbNumber() {
        return bNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int compareTo(Student arg) {
        return self.compareTo(arg.self);
    }

    @Override
    public String toString() {
        return "\n" + self.toString() + ": BNumber=" + bNumber + ", Major=" + major;
    }
}