package lab04;

public class PowerTest {

    public static void main(String[] args) {
        int LENGTH = 5000000;
        int POWER = 15;
        double x = 5.4;
        double[] array1 = new double[LENGTH];
        double[] array2 = new double[LENGTH];
        double[] array3 = new double[LENGTH];
        long t0 = System.currentTimeMillis();
        for(int i = 0; i < array1.length; i++) {
            array1[i] = Math.pow(x, POWER);
        }

        long t1 = System.currentTimeMillis();

        for(int i = 0; i < array1.length; i++) {
            array2[i] = x;
            for(int k = 0; k < POWER-1; k++) {
                array2[i] *= x;
            }
        }

        long t2 = System.currentTimeMillis();

        // I will explain this one in class on Friday:
        int n = POWER; 
        for(int i = 0; i < array1.length; i++) {
            array3[i] = 1;
            while (n > 0) {
                while(n > 0 && n % 2 == 0) {
                    array3[i] *= array3[i];
                    n = n / 2;
                }
                if(n > 0) {
                    array3[i] *= x;
                    n--;
                }
            }   
        }
        long t3 = System.currentTimeMillis();

        System.out.println((t1-t0) + " " +(t2-t1) + " " +(t3-t2));
        System.out.println(array1[0] + " " +array2[0] + " " +array3[0]);
    }

}