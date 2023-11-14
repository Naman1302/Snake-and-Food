package Board;

public class Grid {
    private final int ROW_SIZE, COLUMN_SIZE;
    private Box[][] grid;

    public Grid(int rowSize, int columnSize) {
        ROW_SIZE = rowSize;
        COLUMN_SIZE = columnSize;
        grid=new Box[ROW_SIZE][COLUMN_SIZE];
        for (int row_ptr = 0; row_ptr < ROW_SIZE; row_ptr++) {
            for (int col_ptr = 0; col_ptr < COLUMN_SIZE; col_ptr++) {
                grid[row_ptr][col_ptr] = new Box(row_ptr, col_ptr);
            }
        }
        System.out.println("Grid Generated");
    }

    /* Getters and Setters for board as it's private */
    public Box[][] getGrid() {
        return grid;
    }

    public void setGrid(Box[][] grid) {
        this.grid = grid;
    }

    /* Method for generating food in grid */
    public void generateFood() {
        int row_pos = (int) (Math.random() * ROW_SIZE);
        int col_pos = (int) (Math.random() * COLUMN_SIZE);
        while (grid[row_pos][col_pos].getBoxType() != BoxType.EMPTY_BOX) {
            row_pos = (int) (Math.random() * ROW_SIZE);
            col_pos = (int) (Math.random() * COLUMN_SIZE);
        }
        grid[row_pos][col_pos].setBoxType(BoxType.FOOD_BOX);
        System.out.println("Food is generated at " + row_pos + ", " + col_pos);
    }

    /* Getters & Setters  for row and column size */
    public int getROW_SIZE() {
        return ROW_SIZE;
    }

    public int getCOLUMN_SIZE() {
        return COLUMN_SIZE;
    }
}
