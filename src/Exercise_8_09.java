import java.util.Scanner;

public class Exercise_8_09 {
    public static void main(String[] args) {

        String[][] board = getBoard();

        int gameOver = 0;

        Scanner input = new Scanner(System.in);

        boolean validMove;

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

            // Check if player X won
            if (checkAllWins(board, " X ")){
                gameOver = 1;
                System.out.println("Player X wins!");
                break;
            }

            // Check if the game is a draw
            if (draw(board, "   ")){
                gameOver = 1;
                System.out.println("The game is a draw!");
                break;
            }

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

            // Check if player O won
            if (checkAllWins(board, " O ")){
                gameOver = 1;
                System.out.println("Player O wins!");
                break;
            }

            // Check if the game is a draw
            if (draw(board, "   ")){
                gameOver = 1;
                System.out.println("The game is a draw!");
                break;
            }

        } while (gameOver == 0);
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

    // Method for placing a piece on the board
    public static void placePiece(String[][] board, String piece, int row, int column) {
        board[row][column] = " " + piece + " ";
    }

    // Method for checking if the piece placement is valid
    public static boolean isValidMove(String[][] board, int row, int column) {
        return board[row][column].equals("   ");
    }

    // Check for horizontal win
    public static boolean horizontalWin(String[][] board, String piece) {
        boolean win = false;
        for (int row = 0; row < board.length; row++) {
            if (board[row][0].equals(piece) && board[row][1].equals(piece) && board[row][2].equals(piece))
                win = true;
        }
        return win;
    }

    // Check for vertical win
    public static boolean verticalWin(String[][] board, String piece) {
        boolean win = false;
        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column].equals(piece) && board[1][column].equals(piece) && board[2][column].equals(piece))
                win = true;
        }
        return win;
    }

    // Check for diagonal win
    public static boolean diagonalWin(String[][] board, String piece) {
        boolean win = false;
        if (board[0][0].equals(piece) && board[1][1].equals(piece) && board[2][2].equals(piece))
            win = true;
        return win;
    }

    // Check for antidiagonal win
    public static boolean antidiagonalWin(String[][] board, String piece) {
        boolean win = false;
        if (board[0][2].equals(piece) && board[1][1].equals(piece) && board[2][0].equals(piece))
            win = true;
        return win;
    }

    // Check for win on all lines
    public static boolean checkAllWins(String[][] board, String piece){
        boolean win = false;
        if (horizontalWin(board, piece) || verticalWin(board, piece) || diagonalWin(board, piece) || antidiagonalWin(board,piece))
            win = true;
        return win;
    }

    // Check for draw
    public static boolean draw(String[][] board, String piece){
        boolean draw = true;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column].equals(piece))
                    draw = false;
            }
        }
        return draw;
    }
}

