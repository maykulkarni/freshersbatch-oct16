import java.util.ArrayList;
import java.util.List;

public class nQueens {
    public static List<boolean[][]> list = new ArrayList<>();

    public static void main(String[] args) {
        boolean[][] nQueens = new boolean[4][4];
        solveNQueens(nQueens, 0);
    }

    public static boolean isSafe(boolean board[][], int row, int col) {

        for (int i = 0; i < col; i++)
            if (board[row][i])
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j])
                return false;

        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j])
                return false;

        return true;
    }

    public static void printQueens(boolean[][] config) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(config[i][j] ? "Q" : "-");
            }
            System.out.println();
        }
        System.out.println("*************");
    }

    public static void solveNQueens(boolean[][] config, int currRow) {
        printQueens(config);
        for (int i = 0; i < config.length; i++) {
            if (isSafe(config, currRow, i)) {
                config[i][currRow] = true;
                if (currRow == config.length - 1) {
                    printQueens(config);
                    config[i][currRow] = false;
                } else {
                    solveNQueens(config, currRow + 1);
                }
            }
        }
    }
}