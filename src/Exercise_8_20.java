import java.util.Scanner;

public class Exercise_8_20 {
    public static void main(String[] args) {
        String[][] board = getBoard();
        Scanner input = new Scanner(System.in);
        boolean validMove;
        int gameOver = 0;

        print(board);

        do {
            validMove = false;
            while (!validMove) {
                System.out.println("Drop a red disk at column (0-6)");
                int redColumn = input.nextInt();
                if (redColumn >= 0 && redColumn <= 6) {
                    if (isValidMove(board, redColumn)) {
                        placeDisk(board, "R", redColumn);
                        validMove = true;
                        System.out.println(validMove);
                    } else
                        System.out.println("Disc cannot be placed in a column that has no empty spaces.");
                } else
                    System.out.println("You must choose a column between 0 and 6.");
            }
            print(board);
            if (isConsecutiveFourAntidiagonally(board, "R")){
                System.out.println("The red player won");
                gameOver = 1;
            }

            validMove = false;
            while (!validMove) {
                System.out.println("Drop a yellow disk at column (0-6)");
                int yellowColumn = input.nextInt();
                if (yellowColumn >= 0 && yellowColumn <= 6) {
                    if (isValidMove(board, yellowColumn) && yellowColumn >= 0 && yellowColumn <= 6) {
                        placeDisk(board, "Y", yellowColumn);
                        validMove = true;
                        System.out.println(validMove);
                    } else
                        System.out.println("Disc cannot be placed in a column that has no empty spaces.");
                } else
                    System.out.println("You must choose a column between 0 and 6.");
            }
            print(board);
            if (isConsecutiveFourAntidiagonally(board, "Y")){
                System.out.println("The yellow player won");
                gameOver = 1;
            }

        } while (gameOver == 0);
    }

    // Method for printing out the board
    public static void print(String[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print("|" + m[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }

    // Method for initializing the board array
    public static String[][] getBoard() {
        String[][] board = new String[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = " ";
            }
        }
        return board;
    }

    // Method for placing a piece on the board
    public static void placeDisk(String[][] board, String disc, int column) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column].equals(" ")) {
                board[row][column] = disc;
                break;
            }
        }
    }

    // Method for checking if the piece placement is valid
    public static boolean isValidMove(String[][] board, int column) {
        boolean validMove = false;
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column].equals(" ")) {
                validMove = true;
                break;
            }
        }
        return validMove;
    }

    public static boolean isConsecutiveFour(String[][] board, String disc){
        if (isConsecutiveFourHorizontally(board, disc) || isConsecutiveFourVertically(board, disc)
                || isConsecutiveFourDiagonally(board, disc) || isConsecutiveFourAntidiagonally(board, disc))
            return true;
        return false;
    }

    public static boolean isConsecutiveFourHorizontally(String[][] board, String disc) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length-3; column++) {
                if (board[row][column].equals(disc) && board[row][column+1].equals(disc) && board[row][column+2].equals(disc) && board[row][column+3].equals(disc))
                    return true;
            }
        }
        return false;
    }

    public static boolean isConsecutiveFourVertically(String[][] board, String disc) {
        for (int column = 0; column < board[0].length; column++) {
            for (int row = 0; row < board.length-3; row++) {
                if (board[row][column].equals(disc) && board[row+1][column].equals(disc) && board[row+2][column].equals(disc) && board[row+3][column].equals(disc))
                    return true;
            }
        }
        return false;
    }

    public static boolean isConsecutiveFourDiagonally(String[][] board, String disc) {
        for (int row = 0; row < board.length-3; row++) {
            for (int column = 0; column < board[row].length-3; column++) {
                if (board[row][column].equals(disc) && board[row+1][column+1].equals(disc) && board[row+2][column+2].equals(disc) && board[row+3][column+3].equals(disc))
                    return true;
            }
        }
        return false;
    }

    public static boolean isConsecutiveFourAntidiagonally(String[][] board, String disc) {
        for (int row = 0; row < board.length-3; row++) {
            for (int column = 3; column < board[row].length; column++) {
                if (board[row][column].equals(disc) && board[row+1][column-1].equals(disc) && board[row+2][column-2].equals(disc) && board[row+3][column-3].equals(disc))
                    return true;
            }
        }
        return false;
    }
}

