public class Board {
    private int [][] matrix = new int[3][3];

    public void checkMore(int row, int col) {
        if (this.checkforzero(row, col)) {
            for (int r = row - 2; r < 3; r++) {
                for (int c = col - 2; c < 3; c++) {
                    if (r < 0 || c < 0 || r > matrix[1].length || c > matrix[0].length) {
                        continue;
                    }

                }
            }
        }
    }
    public boolean checkforzero(int row, int col) {
        return matrix[row][col] == 0;
    }
    public void updateBoardSize() {
        matrix = new int[matrix[0].length + 1][matrix[1].length + 1];
    }

}
