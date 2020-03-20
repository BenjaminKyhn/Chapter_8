public class Exercise_8_03 {
    public static void main(String[] args) {
        char[][] answers = {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

        // Key to the answers
        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

        int [][] studentScores = new int[answers.length][2];

        // Grade all answers
        for (int i = 0; i < answers.length; i++) {
            // Grade one student
            int correctCount = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == keys[j])
                    correctCount++;
            }
            studentScores[i][0] = i + 1;
            studentScores[i][1] = correctCount;
        }

        selectionSort(studentScores);

        for (int row = 0; row < studentScores.length; row++) {
                System.out.println("Student " + studentScores[row][0] + "'s correct count is " + studentScores[row][1]);
        }
    }

    public static void selectionSort(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            // Initialize the values in row 0 as the current max values
            int currentMax = matrix[row][1];
            int currentMaxIndex = row;

            // Update current max values
            for (int i = row + 1; i < matrix.length; i++) {
                if (currentMax < matrix[i][1]){
                    currentMax = matrix[i][1];
                    currentMaxIndex = i;
                }
            }

            // Swap currentMax and currentMaxIndex with the values in the next row
            if (currentMaxIndex != row){
                matrix[currentMaxIndex][1] = matrix[row][1];
                matrix[currentMaxIndex][0] = matrix[row][0];
                matrix[row][1] = currentMax;
                matrix[row][0] = currentMaxIndex;
            }
        }
    }
}
