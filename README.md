# QUESTION TWO 
### a)	
import java.util.Scanner;

public class EliteSacco {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double RATE = 0.05;

        System.out.print("Enter number of teachers: ");
        int n = input.nextInt();

        double[] values = new double[n]; // store final amounts

        // --- (i) For Loop: Input & Calculate ---
        for (int i = 0; i < n; i++) {
            System.out.print("Enter principal for teacher " + (i + 1) + ": ");
            double principal = input.nextDouble();

            System.out.print("Enter time in years: ");
            double time = input.nextDouble();

            values[i] = principal + (principal * RATE * time);
        }

        // --- (ii) While Loop: Display Results ---
        int j = 0;
        System.out.println("\n--- Investment Results ---");
        while (j < n) {
            System.out.printf("Teacher %d final value: %.2f%n", (j + 1), values[j]);
            j++;
        }

        input.close();
    }
}

### b)	
import java.util.Scanner;

public class ConcaveMirror {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter object distance (u) in cm (negative for concave mirror): ");
        double u = input.nextDouble();

        System.out.print("Enter image distance (v) in cm: ");
        double v = input.nextDouble();
        double f = 1 / ((1 / v) + (1 / u));
        System.out.printf("Calculated focal length f = %.2f cm%n", f);

        if (f >= 21.0 && f <= 25.0) {
            System.out.println("Mirror is ACCEPTABLE ");
        } else {
            System.out.println("Mirror is NOT acceptable ");
        }

        input.close();
    }
}
c)	
Step-by-Step Analysis:
•	When row = 1:
Inner loop runs while count <= 4 - 1, i.e. count <= 3.
→ It prints ***
•	When row = 2:
Inner loop runs while count <= 4 - 2, i.e. count <= 2.
→ It prints **
•	When row = 3:
Inner loop runs while count <= 4 - 3, i.e. count <= 1.
→ It prints *

