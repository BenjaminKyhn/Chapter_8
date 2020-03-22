import java.util.Scanner;

public class Exercise_8_14 {
    public static void main(String[] args) {
        System.out.println("Enter the size of the matrix: ");
        Scanner input = new Scanner(System.in);
        int matrixSize = input.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        fillMatrix(matrix);
        printMatrix(matrix);

        // Check if the identicalRows contains identical rows and print it out if it does
        int[][] identicalRows = checkForIdenticalRows(matrix);
        boolean identicals = false;
        for (int row = 0; row < matrix.length; row++) {
            if (identicalRows[row][0] == 1){
                System.out.println("All " + identicalRows[row][1] + "'s on row " + (row+1));
                identicals = true;
            }
        }
        if (!identicals)
            System.out.println("No same numbers on a row");

        // Check if the identicalColumns contains identical columns and print it out if it does
        int[][] identicalColumns = checkForIdenticalColumns(matrix);
        identicals = false;
        for (int row = 0; row < matrix.length; row++) {
            if (identicalColumns[row][0] == 1){
                System.out.println("All " + identicalColumns[row][1] + "'s on column " + (row+1));
                identicals = true;
            }
        }
        if (!identicals)
            System.out.println("No same numbers on a column");
    }

    public static void fillMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (int)(Math.random()*2);
            }
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    // Returns a two-dimensional array where the first column indicates if the row is identical (1 = true, 0 = false)
    // and the second column indicates if the row contains 1 or 0
    public static int[][] checkForIdenticalRows(int[][] matrix){
        int[][] identicalsArray = new int[matrix.length][2];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 1; column < matrix[row].length; column++) {
                if (matrix[row][column] == matrix[row][column-1]){
                    identicalsArray[row][0] = 1;
                    identicalsArray[row][1] = matrix[row][column];
                }
                else{
                    identicalsArray[row][0] = 0;
                    break;
                }
            }
        }
        return identicalsArray;
    }

    public static int[][] checkForIdenticalColumns(int[][] matrix){
        int[][] identicalsArray = new int[matrix.length][2];
        for (int column = 0; column < matrix.length; column++) {
            for (int row = 1; row < matrix[column].length; row++) {
                if (matrix[row][column] == matrix[row-1][column]){
                    identicalsArray[column][0] = 1;
                    identicalsArray[column][1] = matrix[row][column];
                }
                else{
                    identicalsArray[column][0] = 0;
                    break;
                }
            }
        }
        return identicalsArray;
    }
}


