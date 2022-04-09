public class Board {
    private int [][] matrix = new int[3][3];

    public void checkMore(int row, int col) {

    }
    public boolean checkforzero(int row, int col) {
        return matrix[row][col] == 0;
    }
    public void updateBoardSize() {
        matrix = new int[matrix[0].length + 1][matrix[1].length + 1];
    }

}
