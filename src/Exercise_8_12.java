import java.util.Scanner;

public class Exercise_8_12 {
    public static void main(String[] args) {
        System.out.println("Enter the number of rows and columns of the array: ");
        Scanner input = new Scanner(System.in);

        // Instantiate the array
        double [][] matrix = new double[input.nextInt()][input.nextInt()];

        // Initialize the array with input values
        System.out.println("Enter the array:" );
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = input.nextDouble();
            }
        }

        printMatrix(matrix);
        System.out.println("The location of the smallest element is at (" + locateSmallest(matrix)[0] + ", " + locateSmallest(matrix)[1] + ")");

    }

    // Locate the smallest value in the matrix
    public static int[] locateSmallest(double[][] a){
        double minValue = a[0][0];
        int[] location = new int[2];
        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < a[row].length; column++) {
                if (a[row][column] < minValue){
                    minValue = a[row][column];
                    location[0] = row;
                    location[1] = column;
                }
            }
        }
        return location;
    }

    // Print the matrix
    public static void printMatrix(double[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
