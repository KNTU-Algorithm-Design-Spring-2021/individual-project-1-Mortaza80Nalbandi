import java.util.Scanner;
import java.util.Arrays;

public class P1A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For 2D ,Enter 2 and for 3D ,Enter 3");
        int nD = scanner.nextInt();
        System.out.println("Enter n");
        int n = scanner.nextInt();
        long[] x = new long[n];
        long[] y = new long[n];
        long[] z = new long[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter x ,Enter y ");
            if (nD == 3) {
                System.out.print("and Enter z ");

            }
            System.out.println("for V" + i + " :");
            x[i] = scanner.nextLong();
            y[i] = scanner.nextLong();
            if (nD == 3) {
                z[i] = scanner.nextLong();
            }
        }
        long[] biggerXs = new long[n / 2];
        long[] biggerYs = new long[n / 2];
        long[] biggerZs = new long[n / 2];
        long[] smallerXs = new long[n / 2];
        long[] smallerYs = new long[n / 2];
        long[] smallerZs = new long[n / 2];
        long oddX = 0;
        long oddY = 0;
        long oddZ = 0;
        int j = 0;
        for (int i = 0; i < n - 1; i = i + 2) {
            if (x[i] >= x[i + 1]) {
                biggerXs[j] = x[i];
                smallerXs[j] = x[i + 1];
            } else if (x[i] < x[i + 1]) {
                biggerXs[j] = x[i + 1];
                smallerXs[j] = x[i];
            }
            if (y[i] >= y[i + 1]) {
                biggerYs[j] = y[i];
                smallerYs[j] = y[i + 1];
            } else if (y[i] < y[i + 1]) {
                biggerYs[j] = y[i + 1];
                smallerYs[j] = y[i];
            }
            if (nD == 3) {
                if (z[i] >= z[i + 1]) {
                    biggerZs[j] = z[i];
                    smallerZs[j] = z[i + 1];
                } else if (z[i] < z[i + 1]) {
                    biggerZs[j] = z[i + 1];
                    smallerZs[j] = z[i];
                }
            }

            j++;
        }
        if (n % 2 == 1) {
            oddX = x[n - 1];
            oddY = y[n - 1];
            if (nD == 3) {
                oddZ = z[n - 1];
            }
        }
        // finding min and max of size=n/2 arrays
        long minX = smallerXs[0];
        long minY = smallerYs[0];
        long minZ = smallerZs[0];
        long maxX = biggerXs[0];
        long maxY = biggerYs[0];
        long maxZ = biggerZs[0];
        for (int i = 0; i < (n / 2); i++) {
            if (biggerXs[i] > maxX) {
                maxX = biggerXs[i];
            }
            if (smallerXs[i] < minX) {
                minX = smallerXs[i];
            }
            if (biggerYs[i] > maxY) {
                maxY = biggerYs[i];
            }
            if (smallerYs[i] < minY) {
                minY = smallerYs[i];
            }
            if (nD == 3) {
                if (biggerZs[i] > maxZ) {
                    maxZ = biggerZs[i];
                }
                if (smallerZs[i] < minZ) {
                    minZ = smallerZs[i];
                }
            }
        }
        if (n % 2 == 1) {
            if (oddX > maxX) {
                maxX = oddX;
            }
            if (oddX < minX) {
                minX = oddX;
            }
            if (oddY > maxY) {
                maxY = oddY;
            }
            if (oddY < minY) {
                minY = oddY;
            }
            if (nD == 3) {
                if (oddZ > maxZ) {
                    maxZ = oddZ;
                }
                if (oddZ < minZ) {
                    minZ = oddZ;
                }
            }
        }
        System.out.println("X  = " + maxX + " , X = " + minX);
        System.out.println("Y  = " + maxY + " , Y = " + minY);
        if (nD == 3) {
            System.out.println("Z  = " + maxZ + " , Z = " + minZ);
        }
    }
}