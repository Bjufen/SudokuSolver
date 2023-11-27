package logic;

public class Grid {
    private Cell[][] grid = new Cell[9][9];
    private Region[] rows = new Region[9];
    private Region[] cols = new Region[9];
    private Region[] blocks = new Region[9];

    //Empty Grid
    public Grid() {
        // Initialize rows, cols, blocks
        for (int i = 0; i < 9; i++) {
            rows[i] = new Region();
            cols[i] = new Region();
            blocks[i] = new Region();
        }
        // Initialize cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new Cell();
                grid[i][j].setRow(rows[i]);
                grid[i][j].setCol(cols[j]);
                grid[i][j].setBlock(blocks[(i / 3) * 3 + j / 3]);
                setRegion2CellRef(rows[i], i, j);
                setRegion2CellRef(cols[j], i, j);
                setRegion2CellRef(blocks[(i / 3) * 3 + j / 3], i, j);
            }
        }
    }
    //Grid with initial values
    public Grid(int[][] initGrid) {
        // Initialize rows, cols, blocks
        for (int i = 0; i < 9; i++) {
            rows[i] = new Region();
            cols[i] = new Region();
            blocks[i] = new Region();
        }
        // Initialize cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(initGrid[i][j] != 0)
                    grid[i][j] = new Cell(initGrid[i][j]);
                else
                    grid[i][j] = new Cell();
                grid[i][j].setRow(rows[i]);
                grid[i][j].setCol(cols[j]);
                grid[i][j].setBlock(blocks[(i / 3) * 3 + j / 3]);
                setRegion2CellRef(rows[i], i, j);
                setRegion2CellRef(cols[j], i, j);
                setRegion2CellRef(blocks[(i / 3) * 3 + j / 3], i, j);

            }
        }
        updateGrid();
    }

    public void setRegion2CellRef(Region region , int i, int j){
        for (int k = 0; k < 9; k++) {
            try {
                int check = region.getValues()[k].getValue();
            }
            catch (NullPointerException e){
                region.setIndividualCell(grid[i][j], k);
                break;
            }
        }
    }


    public void updateGrid() {
        for (int i = 0; i < 9; i++) {
            rows[i].refreshRemainingValues();
            cols[i].refreshRemainingValues();
            blocks[i].refreshRemainingValues();
        }
    }

    public Grid createcopyGrid(){
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = grid[i][j].getValue();
            }
        }
        return new Grid(board);
    }

    public int[][] intValues(){
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = grid[i][j].getValue();
            }
        }
        return board;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    public Region[] getRows() {
        return rows;
    }

    public void setRows(Region[] rows) {
        this.rows = rows;
    }

    public Region[] getCols() {
        return cols;
    }

    public void setCols(Region[] cols) {
        this.cols = cols;
    }

    public Region[] getBlocks() {
        return blocks;
    }

    public void setBlocks(Region[] blocks) {
        this.blocks = blocks;
    }
}
