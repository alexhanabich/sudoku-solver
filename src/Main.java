import model.SudokuBoard;

public class Main {
    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard(new GenerateGrid().generate());

        DisplayGrid displayGrid = new DisplayGrid(sudokuBoard.getGrid());
        System.out.println("Original Sudoku");
        displayGrid.display();

        System.out.println("\n-----------------\n");

        SolveSudoku solveSudoku = new SolveSudoku(sudokuBoard);
        if(solveSudoku.solveSudoku()) {
            System.out.println("Solved Sudoku");
            displayGrid.setGrid(solveSudoku.getGrid());
            displayGrid.display();
        }
        else {
            System.out.println("Unsolvable Sudoku");
        }


    }
}
