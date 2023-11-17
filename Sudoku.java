public class Sudoku {
    public Sudoku(int[][] board) {
        this.board = board;
    }

    private int[][] board;

    public boolean solve() {
        // check if the board is in a valid state
        if (!this.isValid()) {
            return false;
        }

        // iterate through board
        boolean finished;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // find a 0
                if (board[i][j] == 0) {
                    // increment every time we backtrack this far
                    while (board[i][j] < 9) {
                        board[i][j] += 1;
                        finished = solve();

                        // continue the return train on success
                        if (finished) {
                            return true;
                        }
                    }
                    // impossible no matter what value
                    // backtracking so set it back to 0
                    board[i][j] = 0;
                    return false;
                }
            }
        }
        // board is finished
        return true;
    }

    // check if the board is currently in a valid state
    public boolean isValid() {
        boolean success = true;
        // check rows
        for (int i=0;i<9;i++) {
            success = success && valid_group(board[i]);
        }
        // check columns
        for (int j=0;j<9;j++) {
            success = success && valid_group(get_column(j));
        }
        // check 3x3s
        for (int k=0;k<9;k++) {
            success = success && valid_group(get_3x3(k));
        }
        return success;
    }

    // check if a list of 9 integers has every number
    public boolean valid_group(int[] group){
        boolean[] seen_numbers = {false,false,false,false,false,false,false,false,false};
        for (int i=0;i<9;i++) {
            if (group[i]==0) {
                continue;
            }
            if(seen_numbers[group[i]-1]) {
                return false;
            } else {
                seen_numbers[group[i]-1] = true;
            }
        }
        return true;
    }

    // get a column from the board
    public int[] get_column(int j) {
        int[] column = new int[9];
        for (int i = 0; i<9; i++) {
            column[i] = board[i][j];
        }
        return column;
    }

    // get the numbers in a 3x3 area
    // 0 1 2
    // 3 4 5
    // 6 7 8
    public int[] get_3x3(int index) {
        int i = 3 * (index / 3);
        int j = 3 * (index % 3);
        int[] results = {
                board[i][j],board[i][j+1],board[i][j+2],
                board[i+1][j],board[i+1][j+1],board[i+1][j+2],
                board[i+2][j],board[i+2][j+1],board[i+2][j+2]
        };
        return results;

    }


    public String toString() {
        String result = "";
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                result = result + board[i][j] + " ";

                if (j%3 == 2) {
                    result = result + "   ";
                }
            }

            result = result + "\n";
            if (i%3 == 2) {
                result = result + "\n";
            }
        }
        return result;
    }
}
