public class Exercise_8_23 {
    public static void main(String[] args) {
        int[][] matrix = new int[6][6];
        // Fill the first 5x5 part of the matrix with 1's or 0's randomly
        fillMatrix(matrix);

        // Correct the rows so that there are always an equal amount of 1's
        correctRows(matrix);

        // Correct the columns so that there are always an equal amount of 1's
        correctColumns(matrix);

        // Flip a random cell
        flipCell(matrix);

        // Print out the matrix
        printMatrix(matrix);
    }

    // Fill the matrix with 0's and 1's
    public static void fillMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) { // leave last row clear
            for (int column = 0; column < matrix[row].length - 1; column++) { // leave last column clear
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


    // Method for checking and correcting the rows
    public static void correctRows(int[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            int sum = 0;
            for (int column = 0; column < matrix[row].length - 1; column++) {
                sum += matrix[row][column];
            }
            if (sum % 2 != 0)
                matrix[row][5] = 1;
        }
    }

    // Method for checking and correcting the columns
    public static void correctColumns(int[][] matrix) {
        for (int column = 0; column < matrix[0].length; column++) {
            int sum = 0;
            for (int row = 0; row < matrix.length - 1; row++) {
                sum += matrix[row][column];
            }
            if (sum % 2 != 0)
                matrix[5][column] = 1;
        }
    }

    // Method for flipping a random cell
    public static void flipCell(int[][] matrix) {
        int row = (int) (Math.random() * 6);
        int column = (int) (Math.random() * 6);
        if (matrix[row][column] == 0)
            matrix[row][column] = 1;
        else if (matrix[row][column] == 1)
            matrix[row][column] = 0;
    }
}
