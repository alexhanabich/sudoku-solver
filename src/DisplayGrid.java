public class DisplayGrid {

    private int[][] grid;

    public DisplayGrid(int[][] grid) {
        this.grid = grid;
    }

    public void display() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j ++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
