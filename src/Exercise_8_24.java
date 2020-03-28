import java.util.Scanner;

public class Exercise_8_24 {
    public static void main(String[] args) {
        // Read a Sudoku solution
        int[][] grid = {
                {9, 6, 3, 1, 7, 4, 2, 5, 8},
                {1, 7, 8, 3, 2, 5, 6, 4, 9},
                {2, 5, 4, 6, 8, 9, 7, 3, 1},
                {8, 2, 1, 4, 3, 7, 5, 9, 6},
                {4, 9, 6, 8, 5, 2, 3, 1, 7},
                {7, 3, 5, 9, 6, 1, 8, 2, 4},
                {5, 8, 9, 7, 1, 3, 4, 6, 2},
                {3, 1, 7, 2, 4, 6, 9, 8, 5},
                {6, 4, 2, 5, 9, 8, 1, 7, 3},
        };
        System.out.println(isValid(grid) ? "Valid solution" : "Invalid solution");
    }

    public static int[][] readASolution() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Sudoku puzzle solution: ");
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                grid[i][j] = input.nextInt();

        return grid;
    }

    // Check whether a solution is valid
    public static boolean isValid(int[][] grid) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grid[i][j] < 1 || grid[i][j] > 9 || !isValid(i, j, grid))
                    return false;
        return true; // The solution is valid
    }

    // Check whether grid[i][j] is valid in the grid
    public static boolean isValid(int i, int j, int[][] grid) {
        int[][] numbers = {
                {1, 0},
                {2, 0},
                {3, 0},
                {4, 0},
                {5, 0},
                {6, 0},
                {7, 0},
                {8, 0},
                {9, 0},
        };
        // Count the number of occurrences of each number in each row
        for (int column = 0; column < 9; column++) {
            for (int k = 0; k < numbers.length; k++) {
                if (grid[i][column] == numbers[k][0])
                    numbers[k][1]++;
            }
        }

        // Check if any number appears more than once and reset the numbers matrix
        for (int k = 0; k < numbers.length; k++) {
            if (numbers[k][1] != 1)
                return false;
            else
                numbers[k][1] = 0;
        }

        // Count the number of occurrences of each number in each column
        for (int row = 0; row < 9; row++) {
            for (int k = 0; k < numbers.length; k++) {
                if (grid[row][j] == numbers[k][0])
                    numbers[k][1]++;
            }
        }

        // Check if any number appears more than once and reset the numbers matrix
        for (int k = 0; k < numbers.length; k++) {
            if (numbers[k][1] != 1)
                return false;
            else
                numbers[k][1] = 0;
        }

        // Count the number of occurrences of each number in each 3-by-3 box
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                for (int k = 0; k < numbers.length; k++) {
                    if (grid[row][col] == numbers[k][0])
                        numbers[k][1]++;
                }
            }
        }

        // Check if any number appears more than once
        for (int k = 0; k < numbers.length; k++) {
            if (numbers[k][1] != 1)
                return false;
        }

        return true;
        // The current value at grid[i][j] is valid because each number only appears once in the row, column and grid
    }
}
