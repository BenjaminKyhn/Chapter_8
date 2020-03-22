public class Exercise_8_10 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];

        // Fill the array with 0's and 1's
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (int)(Math.random()*2);
            }
        }

        printMatrix(matrix);
        System.out.println("The largest row index: " + indexOfMaxRow(matrix));
        System.out.println("The largest column index: " + indexOfMaxColumn(matrix));

    }

    public static int indexOfMaxRow(int[][] matrix){
        // Instantiate variables for finding the max row
        int maxRow = 0;
        int indexOfMaxRow = 0;

        // Get sum of the first row in maxRow
        for (int column = 0; column < matrix[0].length; column++) {
            maxRow += matrix[0][column];
        }

        // Find the row with the max value
        for (int row = 1; row < matrix.length; row++) {
            int totalOfThisRow = 0;
            for (int column = 0; column < matrix[row].length; column++)
                totalOfThisRow += matrix[row][column];
            if (totalOfThisRow > maxRow) {
                maxRow = totalOfThisRow;
                indexOfMaxRow = row;
            }
        }
        return indexOfMaxRow;
    }

    public static int indexOfMaxColumn(int[][] matrix){
        // Instantiate variables for finding the max column
        int maxColumn= 0;
        int indexOfMaxColumn = 0;

        // Get sum of the first column in maxColumn
        for (int column = 0; column < matrix[0].length; column++) {
            maxColumn += matrix[column][0];
        }

        // Find the column with the max value
        for (int column = 1; column < matrix[0].length; column++) {
            int totalOfThisColumn = 0;
            for (int row = 0; row < matrix.length; row++) {
                totalOfThisColumn += matrix[row][column];
            }
            if (totalOfThisColumn > maxColumn){
                maxColumn = totalOfThisColumn;
                indexOfMaxColumn = column;
            }
        }
        return indexOfMaxColumn;
    }

    // Print the array
    public static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}

