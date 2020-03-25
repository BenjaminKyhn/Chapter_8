public class Exercise_8_18 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};

        shuffleRows(matrix);

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    // Shuffles all the elements
    public static void shuffle(int[][] m) {
        // Shuffle the cards
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                // Generate an index randomly
                int rowIndex = (int) (Math.random() * m.length);
                int columnIndex = (int) (Math.random() * m[0].length);
                int temp = m[row][column];
                m[row][column] = m[rowIndex][columnIndex];
                m[rowIndex][columnIndex] = temp;
            }
        }
    }

    // Shuffles the rows
    public static void shuffleRows(int[][] m) {
        // Shuffle the cards
        for (int row = 0; row < m.length; row++) {
            // Generate an index randomly
            int index = (int) (Math.random() * m.length);
            int[] temp = new int[m[row].length];
            for (int column = 0; column < m[row].length; column++) {
                temp[column] = m[row][column];
                m[row][column] = m[index][column];
                m[index][column] = temp[column];
            }
        }
    }
}
