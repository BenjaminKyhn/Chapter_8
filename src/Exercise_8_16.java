public class Exercise_8_16 {
    public static void main(String[] args) {
        int[][] matrix = {
                {4, 2, 3},
                {6, 4, 1},
                {2, 3, 9},
                {4, 7, 0},
                {1, 4, 2},
                {8, 2, 4},
                {2, 7, 7},
        };

        // Sort the array
        sort(matrix);

        // Print the array
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }


    public static void sort(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            // Initialize the first element in the array as the max value
            int currentMax = m[i][0];
            int currentMaxIndex = i;
            int [] currentMaxValues = new int[m[i].length];

            // Check if the neck element is greater than the current max value
            for (int j = i + 1; j < m.length; j++) {
                if (currentMax < m[j][0]) {
                    currentMax = m[j][0];
                    currentMaxIndex = j;
                    for (int k = 0; k < m[i].length; k++) {
                        currentMaxValues[k] = m[j][k];
                    }
                }
            }

            // Swap the array elements in the two rows (current row and max row)
            if (currentMaxIndex != i) {
                for (int column = 0; column < m[currentMaxIndex].length; column++) {
                    m[currentMaxIndex][column] = m[i][column];
                    m[i][column] = currentMaxValues[column];
                }
            }
        }

//        // Sort by column
//        for (int row = 1; row < m.length; row++) {
//            for (int column = 1; column < m[row].length; column++) {
//                // Initialize the first element in the array as the max value
//                int currentMax = m[row][column];
//                int currentMaxIndex = row;
//                int [] currentMaxValues = new int[m[i].length];
//
//                if (m[row][column-1] == m[row-1][column-1] && m[row][column] < m[row-1][column])
//            }
//        }
    }


    // Descending selection sort
    public static void selectionSortDescending(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int currentMax = numbers[i];
            int currentMaxIndex = i;

            for (int j = i + 1; j < numbers.length; j++) {
                if (currentMax < numbers[j]) {
                    currentMax = numbers[j];
                    currentMaxIndex = j;
                }
            }

            if (currentMaxIndex != i) {
                numbers[currentMaxIndex] = numbers[i];
                numbers[i] = currentMax;
            }
        }
    }
}
