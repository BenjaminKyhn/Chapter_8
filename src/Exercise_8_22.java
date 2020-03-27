import java.util.Scanner;

public class Exercise_8_22 {
    public static void main(String[] args) {
        int[][] matrix = new int[6][6];
        fillMatrix(matrix);
        printMatrix(matrix);

        // Check rows
        for (int row = 0; row < matrix.length; row++) {
            if (checkRows(matrix, row))
                System.out.println("Row " + row + " has an even number of 1's");
        }

        // Check columns
        for (int column = 0; column < matrix[0].length; column++) {
            if (checkColumns(matrix, column))
                System.out.println("Column " + column + " has an even number of 1's");
        }
    }

    // Fill the matrix with 0's and 1's
    public static void fillMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (int) (Math.random() * 2);
            }
        }
    }

    // Print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    // Method for checking rows
    public static boolean checkRows(int[][] matrix, int row) {
        int count = 0;
        for (int column = 0; column < matrix[row].length; column++) {
            if (matrix[row][column] == 1)
                count++;
        }
        if (count != 0 && count % 2 == 0)
            return true;
        return false;
    }

    // Method for checking columns
    public static boolean checkColumns(int[][] matrix, int column) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][column] == 1)
                count++;
        }
        if (count != 0 && count % 2 == 0)
            return true;
        return false;
    }
}
