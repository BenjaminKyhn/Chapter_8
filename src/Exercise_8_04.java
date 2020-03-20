public class Exercise_8_04 {
    public static void main(String[] args) {
        int[][] workHours = {
                {2, 4, 3, 4, 5, 8, 8},
                {7, 3, 4, 3, 3, 4, 4},
                {3, 3, 4, 3, 3, 2, 2},
                {9, 3, 4, 7, 3, 4, 1},
                {3, 5, 4, 3, 6, 3, 8},
                {3, 4, 4, 6, 3, 4, 4},
                {3, 7, 4, 8, 3, 8, 4},
                {6, 3, 5, 9, 2, 7, 9}};

        int[][] sumOfWorkHours = new int[workHours.length][2];

        for (int row = 0; row < workHours.length; row++) {
            sumOfWorkHours[row][0] = row;
            int sum = 0;
            for (int column = 0; column < workHours[row].length; column++) {
                sum += workHours[row][column];
            }
            sumOfWorkHours[row][1] = sum;
        }

        selectionSort(sumOfWorkHours);

        for (int i = 0; i < sumOfWorkHours.length; i++) {
            System.out.println("Employee " + sumOfWorkHours[i][0] + "'s total hours is " + sumOfWorkHours[i][1]);
        }
    }

    public static void selectionSort(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            int currentMin = matrix[row][1];
            int currentMinIndex = row;

            for (int i = row + 1; i < matrix.length; i++) {
                if (currentMin > matrix[i][1]){
                    currentMin = matrix[i][1];
                    currentMinIndex = i;
                }
            }

            if (currentMinIndex != row){
                matrix[currentMinIndex][1] = matrix[row][1];
                matrix[currentMinIndex][0] = matrix[row][0];
                matrix[row][1] = currentMin;
                matrix[row][0] = currentMinIndex;
            }
        }
    }
}


