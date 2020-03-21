import java.util.Scanner;

public class Exercise_8_09 {
    public static void main(String[] args) {

        String[][] board = getBoard();

        String gameOver = "no";

        Scanner input = new Scanner(System.in);

        boolean validMove = false;

        do {
            print(board);

            // Player X move
            validMove = false;
            while (!validMove) {
                System.out.println("Enter a row (0, 1 or 2) for player X: ");
                int rowX = input.nextInt();
                System.out.println("Enter a column (0, 1 or 2) for player X: ");
                int columnX = input.nextInt();
                if (isValidMove(board, rowX, columnX)) {
                    placePiece(board, "X", rowX, columnX);
                    validMove = true;
                }
            }
            print(board);
            System.out.println("Is there a win for X? " + horizontalWin(board, " X "));

            // Player Y move
            validMove = false;
            while (!validMove) {
                System.out.println("Enter a row (0, 1 or 2) for player O: ");
                int rowO = input.nextInt();
                System.out.println("Enter a column (0, 1 or 2) for player O: ");
                int columnO = input.nextInt();
                if (isValidMove(board, rowO, columnO)) {
                    placePiece(board, "O", rowO, columnO);
                    validMove = true;
                }
            }
            print(board);
            System.out.println("Is there a win for O? " + verticalWin(board, " O "));

        } while (gameOver.equals("no"));


    }

    // Method for initializing the board array
    public static String[][] getBoard() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "   ";
            }
        }
        return board;
    }

    // Method for printing out the board
    public static void print(String[][] m) {
        System.out.println("\n-------------");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print("|" + m[i][j]);
            }
            System.out.println("|\n-------------");
        }
    }

    public static void placePiece(String[][] board, String piece, int row, int column) {
        board[row][column] = " " + piece + " ";
    }

    public static boolean isValidMove(String[][] board, int row, int column) {
        return board[row][column].equals("   ");
    }

    public static boolean horizontalWin(String[][] board, String piece) {
        boolean win = false;
        for (int row = 0; row < board.length; row++) {
            if (board[row][0].equals(piece) && board[row][1].equals(piece) && board[row][2].equals(piece))
                win = true;
        }
        return win;
    }

    public static boolean verticalWin(String[][] board, String piece) {
        boolean win = false;
        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column].equals(piece) && board[1][column].equals(piece) && board[2][column].equals(piece))
                win = true;
        }
        return win;
    }
}

