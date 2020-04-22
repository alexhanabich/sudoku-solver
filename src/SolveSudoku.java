import model.SudokuBoard;

public class SolveSudoku {

    private SudokuBoard sudokuBoard;
    private int ROW_LENGTH;
    private int COLUMN_LENGTH;
    private int BOX_LENGTH;
    private int[][] grid;
    private int UNASSIGNED;

    public SolveSudoku(SudokuBoard sudokuBoard) {
        setSudokuBoard(sudokuBoard);
    }

    public boolean solveSudoku() {
        for (int i = 0; i < ROW_LENGTH; i++) {
            for (int j = 0; j < COLUMN_LENGTH; j++) {
                if (grid[i][j] == UNASSIGNED) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidNum(i, j, num)) {
                            grid[i][j] = num;
                            if (solveSudoku()) {
                                return true;
                            }
                            else {
                                grid[i][j] = UNASSIGNED;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        this.grid = sudokuBoard.getGrid();
        this.ROW_LENGTH = grid.length;
        this.COLUMN_LENGTH = grid[0].length;
        this.BOX_LENGTH = ROW_LENGTH/3;
        this.UNASSIGNED = 0;
    }

    private boolean isValidNum(int row, int col, int num) {
        return !isNumInRow(row, num) && !isNumInColumn(col, num) && !isNumInBox(row, col, num);
    }

    private boolean isNumInRow(int row, int num) {
        for (int col = 0; col < COLUMN_LENGTH; col++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumInColumn(int col, int num) {
        for (int row = 0; row < ROW_LENGTH; row++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumInBox(int row, int col, int num) {
        int startIndexRow = (row / BOX_LENGTH) * BOX_LENGTH;
        int startIndexCol = (col / BOX_LENGTH) * BOX_LENGTH;
        for (int i = startIndexRow; i < startIndexRow + 3; i++) {
            for (int j = startIndexCol; j < startIndexCol + 3; j++) {
                if (grid[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] getGrid() {
        return grid;
    }
}
