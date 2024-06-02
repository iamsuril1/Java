import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static char currentPlayer = PLAYER_X;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            initializeBoard();
            while (true) {
                printBoard();
                playerMove();
                printBoard(); // Show the board after every move
                if (isWinner(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }
                if (isBoardFull()) {
                    System.out.println("The game is a tie!");
                    break;
                }
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        } finally {
            scanner.close(); // Close the scanner to prevent resource leak
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playerMove() {
        int move;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            move = scanner.nextInt();
            if (move >= 1 && move <= 9 && isValidMove(move)) {
                placeMove(move);
                break;
            } else {
                System.out.println("This move is not valid");
            }
        }
    }

    private static boolean isValidMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        return board[row][col] == '-';
    }

    private static void placeMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        board[row][col] = currentPlayer;
    }

    private static boolean isWinner(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
