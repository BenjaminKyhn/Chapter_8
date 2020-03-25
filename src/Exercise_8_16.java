public class Exercise_8_16 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 6},
                {1, 2, 3, 1},
                {1, 2, 3, 9},
                {1, 2, 3, 0},
                {1, 2, 3, 7},
                {1, 2, 3, 4},
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
            int[] currentMaxValues = new int[m[i].length];

            // Check if the next element is greater than the current max value
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

        // Sort by column
        for (int column = 1; column < m[0].length; column++) {
            for (int row = 0; row < m.length; row++) {
                // Initialize the first element in the array as the max value
                /** if-else state that only initializes currentMax if the values in the first column are the same. Else we'll have 8-2-1 swap with 6-5-0 because the second element in 6-5-0 is greater */
                int currentMax = m[row][column];
                int currentMaxIndex = row;
                int[] currentMaxValues = new int[m[row].length];

                for (int i = row + 1; i < m.length; i++) {
                    // Check if the element in the current column of the current row is smaller than the element in the current column of the previous row
                    if (m[row][column - 1] == m[row + 1][column - 1] && currentMax < m[row + 1][column]) {
                        currentMax = m[row + 1][column];
                        currentMaxIndex = row + 1;

                        // Add the entire row of the max value to an array to store the row
                        for (int k = 0; k < m[currentMaxIndex].length; k++) {
                            currentMaxValues[k] = m[currentMaxIndex][k];
                        }
                    }
                }

                // Swap the array elements in the two rows (current row and max row)
                if (currentMaxIndex != row) {
                    for (int j = column; j < m[currentMaxIndex].length; j++) {
                        m[currentMaxIndex][j] = m[row][j];
                        m[row][j] = currentMaxValues[j];
                    }
                }
            }
        }

//        // Sort by column
//        for (int row = 0; row < m.length-1; row++) {
//            for (int column = 1; column < m[row].length; column++) {
//                // Initialize the first element in the array as the max value
//                /** if-else state that only initializes currentMax if the values in the first column are the same. Else we'll have 8-2-1 swap with 6-5-0 because the second element in 6-5-0 is greater */
//                int currentMax = m[row][column];
//                int currentMaxIndex = row;
//                int[] currentMaxValues = new int[m[row].length];
//
//                for (int i = row + 1; i < m.length; i++) {
//                    // Check if the element in the current column of the current row is smaller than the element in the current column of the previous row
//                    if (m[row][column - 1] == m[row + 1][column - 1] && currentMax < m[row + 1][column]) {
//                        currentMax = m[row + 1][column];
//                        currentMaxIndex = row + 1;
//
//                        // Add the entire row of the max value to an array to store the row
//                        for (int k = 0; k < m[currentMaxIndex].length; k++) {
//                            currentMaxValues[k] = m[currentMaxIndex][k];
//                        }
//                    }
//                }
//
//                // Swap the array elements in the two rows (current row and max row)
//                if (currentMaxIndex != row) {
//                    for (int j = column; j < m[currentMaxIndex].length; j++) {
//                        m[currentMaxIndex][j] = m[row][j];
//                        m[row][j] = currentMaxValues[j];
//                    }
//                }
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
