public class Board {

    private int [][] matrix;

    public Board() {
        matrix = new int[3][3];
    }

    public void checkMore(int row, int col) {
        if (this.checkforzero(row, col)) {
            matrix[row][col] += 1;

        }
        updateBoardSize();
    }
    public boolean checkforzero(int row, int col) {
        return matrix[row][col] == 0;
    }
    public void updateBoardSize() {
        if (checkFull()) {
            matrix = new int[matrix[0].length + 1][matrix.length + 1];
        }
    }

    public boolean checkFull() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getWidth() {
        return matrix[0].length;
    }
}
