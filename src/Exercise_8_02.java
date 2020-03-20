import java.util.Scanner;

public class Exercise_8_02 {
    public static double averageMajorDiagonal(double[][] m) {
        double sum = 0;

        for (int row = 0; row < m.length; row++) {
            sum += m[row][row];
        }

        return sum/m.length;
    }

    public static void main(String[] args) {
        double[][] array = new double[4][4];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 4−by−4 matrix row by row: ");
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                array[row][column] = input.nextDouble();
            }
        }

        System.out.println("Average of the elements in the major diagonal is " + averageMajorDiagonal(array));
    }
}
