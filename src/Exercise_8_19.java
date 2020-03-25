import java.util.Scanner;

public class Exercise_8_19 {
    public static void main(String[] args) {
        System.out.println("Enter the number of rows and columns: ");
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[input.nextInt()][input.nextInt()];
        System.out.println("Enter the numbers in the matrix: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = input.nextInt();
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }

        if (isConsecutiveFour(matrix)){
            if (isConsecutiveFourHorizontally(matrix))
                System.out.println("There are 4 consecutive numbers horizontally in the matrix");
            if (isConsecutiveFourVertically(matrix))
                System.out.println("There are 4 consecutive numbers vertically in the matrix");
            if (isConsecutiveFourDiagonally(matrix))
                System.out.println("There are 4 consecutive numbers diagonally in the matrix");
            if (isConsecutiveFourAntidiagonally(matrix))
                System.out.println("There are 4 consecutive numbers antidiagonally in the matrix");
        }

    }

    public static boolean isConsecutiveFour(int[][] values){
        if (isConsecutiveFourHorizontally(values) || isConsecutiveFourVertically(values) || isConsecutiveFourDiagonally(values) || isConsecutiveFourAntidiagonally(values))
            return true;
        return false;
    }

    public static boolean isConsecutiveFourHorizontally(int[][] values) {
        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[row].length-3; column++) {
                if (values[row][column] == values[row][column+1] && values[row][column] == values[row][column+2] && values[row][column] == values[row][column+3])
                    return true;
            }
        }
        return false;
    }

    public static boolean isConsecutiveFourVertically(int[][] values) {
        for (int column = 0; column < values[0].length; column++) {
            for (int row = 0; row < values.length-3; row++) {
                if (values[row][column] == values[row+1][column] && values[row][column] == values[row+2][column] && values[row][column] == values[row+3][column])
                    return true;
            }
        }
        return false;
    }

    public static boolean isConsecutiveFourDiagonally(int[][] values) {
        for (int row = 0; row < values.length-3; row++) {
            for (int column = 0; column < values[row].length-3; column++) {
                if (values[row][column] == values[row+1][column+1] && values[row][column] == values[row+2][column+2] && values[row][column] == values[row+3][column+3])
                    return true;
            }
        }
        return false;
    }

    public static boolean isConsecutiveFourAntidiagonally(int[][] values) {
        for (int row = 0; row < values.length-3; row++) {
            for (int column = 3; column < values[row].length; column++) {
                if (values[row][column] == values[row+1][column-1] && values[row][column] == values[row+2][column-2] && values[row][column] == values[row+3][column-3])
                    return true;
            }
        }
        return false;
    }
}


