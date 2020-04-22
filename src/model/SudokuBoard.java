package model;

public class SudokuBoard {

    private int[][] grid;

    public SudokuBoard(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}

