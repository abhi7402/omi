package abhi1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueen1 {
    static int N;

    static boolean isValid(int[][] board, int row, int col) {
        // Check for left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check for left upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check for left lower diagonal
        for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }
        // Otherwise, placement is valid
        return true;
    }

    static void solve(int[][] board, int col, List<int[][]> solutions) {
        if (col == N) {
            int[][] solution = new int[N][N];
            // Copy the board state to the solution array
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    solution[i][j] = board[i][j];
                }
            }
            // Add the solution to the list
            solutions.add(solution);
            return;
        }

        for (int row = 0; row < N; row++) {
            if (isValid(board, row, col)) {
                board[row][col] = 1;
                solve(board, col + 1, solutions);
                board[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N (must be greater than 3): ");
        N = sc.nextInt();
        if (N <= 3) {
            System.out.println("No Solution");
        } else {
            int board[][] = new int[N][N];
            List<int[][]> solutions = new ArrayList<>();
            solve(board, 0, solutions);

            System.out.println("\n-----Solutions-----\n");
            for (int[][] solution : solutions) {
                for (int i = 0; i < solution.length; i++) {
                    for (int j = 0; j < solution.length; j++) {
                        System.out.print(" " + solution[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
        sc.close();
    }
}