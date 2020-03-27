import java.util.Scanner;

public class Exercise_8_22 {
    public static void main(String[] args) {
        int[][] matrix = new int[6][6];
        fillMatrix(matrix);
        printMatrix(matrix);
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


}
