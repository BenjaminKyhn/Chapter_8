import java.util.Scanner;

public class Exercise_8_30 {
    public static void main(String[] args) {
        double[][] a = new double[2][2];
        double[] b = new double[2];
        System.out.println("Enter a00, a01, a10 and a11: ");
        Scanner input = new Scanner(System.in);

        // Get input for a
        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < a[row].length; column++) {
                a[row][column] = input.nextDouble();
            }
        }

        System.out.println("Enter b0 and b1: ");
        // Get input for b
        for (int i = 0; i < b.length; i++) {
            b[i] = input.nextDouble();
        }

        if (linearEquation(a, b) == null)
            System.out.println("The equation has no solution.");
        else
            System.out.println("x is " + linearEquation(a, b)[0] + " and y is " + linearEquation(a, b)[1] + ".");
    }

    public static double[] linearEquation(double[][] a, double[] b) {
        if ((a[0][0] * a[1][1]) - (a[0][1] * a[1][0]) == 0)
            return null;

        double[] xy = new double[2];
        xy[0] = ((b[0] * a[1][1]) - (b[1] * a[0][1])) / ((a[0][0] * a[1][1]) - (a[0][1] * a[1][0]));
        xy[1] = ((b[1] * a[0][0]) - (b[0] * a[1][0])) / ((a[0][0] * a[1][1]) - (a[0][1] * a[1][0]));
        return xy;
    }
}
