import java.util.Scanner;

public class Exercise_8_27 {
    public static void main(String[] args) {
        double[][] matrix = {
                {0.15, 0.875, 0.375, 0.225},
                {0.55, 0.005, 0.225, 0.015},
                {0.30, 0.12, 0.4, 0.008},
                {0.07, 0.021, 0.14, 0.2},
        };

        double[][] matrix2 = new double[4][4];

        System.out.println("Enter a 4-by-4 matrix row by row: ");
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < matrix2.length; row++) {
            for (int column = 0; column < matrix2[row].length; column++) {
                matrix2[row][column] = input.nextDouble();
            }
        }

        // Print out the sorted matrix
        System.out.println("The row-sorted array is: ");
        printMatrix(sortColumns(matrix2));
    }

    // Method for sorting the rows
    public static double[][] sortColumns(double[][] m) {
        double[][] sortedMatrix = m;

        for (int column = 0; column < sortedMatrix[0].length; column++) {
            for (int row = 0; row < sortedMatrix.length; row++) {
                double currentMin = sortedMatrix[row][column];
                int currentMinIndex = row;

                for (int j = row + 1; j < sortedMatrix.length; j++) {
                    if (currentMin > sortedMatrix[j][column]){
                        currentMin = sortedMatrix[j][column];
                        currentMinIndex = j;
                    }
                }

                if (currentMinIndex != row){
                    sortedMatrix[currentMinIndex][column] = sortedMatrix[row][column];
                    sortedMatrix[row][column] = currentMin;
                }
            }
        }
        return sortedMatrix;
    }

    // Print the matrix
    public static void printMatrix(double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                String num = Double.toString(matrix[row][column]);
                StringBuilder sb = new StringBuilder(num);
                while (sb.length() < 6) {
                    sb.append(' ');
                }
                System.out.print(sb + " ");

            }
            System.out.println();
        }
    }
}
