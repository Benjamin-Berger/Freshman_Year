package assignment05;
import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student arg0, Student arg1) {
        int retVal = 0;
        if(arg0.getClass() != arg1.getClass()) {
            if(arg0.getClass() == GraduateStudent.class) {
                retVal = 1;
            } else {
                retVal = -1;
            }
        }
        if(retVal == 0) { // same class
            retVal = arg0.getMajor().compareTo(arg1.getMajor());
        }
        if(retVal == 0) { // same class, same major
            retVal = arg0.compareTo(arg1);
        }
        return retVal;
    }
}