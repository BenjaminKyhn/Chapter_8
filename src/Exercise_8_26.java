import java.util.Scanner;

public class Exercise_8_26 {
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
        printMatrix(sortRows(matrix2));
    }

    // Method for sorting the rows
    public static double[][] sortRows(double[][] m) {
        double[][] sortedMatrix = m;

        for (int row = 0; row < sortedMatrix.length; row++) {
            for (int column = 0; column < sortedMatrix[row].length; column++) {
                double currentMin = sortedMatrix[row][column];
                int currentMinIndex = column;

                for (int j = column + 1; j < sortedMatrix[row].length; j++) {
                    if (currentMin > sortedMatrix[row][j]){
                        currentMin = sortedMatrix[row][j];
                        currentMinIndex = j;
                    }
                }

                if (currentMinIndex != column){
                    sortedMatrix[row][currentMinIndex] = sortedMatrix[row][column];
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
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
