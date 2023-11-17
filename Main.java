public class Main {
    public static void main(String[] args) {
        int[][] board = {
                {5,3,0,  0,7,0,  0,0,0},
                {6,0,0,  1,9,5,  0,0,0},
                {0,9,8,  0,0,0,  0,6,0},

                {8,0,0,  0,6,0,  0,0,3},
                {4,0,0,  8,0,3,  0,0,1},
                {7,0,0,  0,2,0,  0,0,6},

                {0,6,0,  0,0,0,  2,8,0},
                {0,0,0,  4,1,9,  0,0,5},
                {0,0,0,  0,8,0,  0,7,9}
        };
        Sudoku sudoku = new Sudoku(board);
        System.out.println("Start:");
        System.out.println(sudoku);
        boolean success = sudoku.solve();
        if (success) {
            System.out.println("Solution:");
            System.out.println(sudoku);
        }
        else {
            System.out.println("No solution found.");
        }
    }
}