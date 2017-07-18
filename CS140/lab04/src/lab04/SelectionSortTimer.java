package lab04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelectionSortTimer {  
    public static void main(String[] args) { 
        int n = 1;
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        while (n > 0) {
            System.out.print("Enter array size: (0 to exit) ");
            n = in.nextInt();

            // Construct random array

            double[] a = new double[n]; 
            double[] copy; 
            for(int i = 0; i < n; i++) {
                a[i] = random.nextDouble();
            }
            copy = a.clone();

            long t0 = System.currentTimeMillis();

            SelectionSort.sort(a);

            long t1 = System.currentTimeMillis();

            Arrays.sort(copy);

            long t2 = System.currentTimeMillis();

            System.out.println("Elapsed times: " + (t1-t0) + " and " 
                    + (t2-t1) + " milliseconds");
        }
        in.close();

    }
}