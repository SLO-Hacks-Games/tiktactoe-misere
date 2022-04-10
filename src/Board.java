public class Board {

    private int [][] matrix;

    public Board() {
        matrix = new int[3][3];
    }

    public void checkMore(int row, int col) {
        if (this.checkforzero(row, col)) {
            matrix[row][col] += 1;
            for (int r = row - 1; r < row + 2; r++) {
                for (int c = col - 1; c < col + 2; c++) {

                    if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || (r == row && c == col)) {
                        continue;
                    }

                    // check to see everything around it
                    if (r < row && c < col) {
                        if (r - 1 > 0 && c - 1 > 0) {

                            // put the box between as 2
                            if (matrix[r-1][c-1] == 1) {
                                matrix[r][c] = 2;
                            }
                            else if (matrix[r][c] == 1) {
                                matrix[r - 1][r - 1] = 2;
                            }
                        }
                        else {
                            continue;
                        }
                    }
                    // middle top
                    else if (r < row && c == col) {
                        if (r - 1 > 0) {
                            if (matrix[r - 1][c] == 1) {
                                matrix[r][c] = 2;
                            }
                            else if (matrix[r][c] == 1){
                                matrix[r][c] = 2;
                            }
                        }
                        else {
                            continue;
                        }
                    }

                    // top right
                    else if (r < row && c > col) {
                        if (r - 1 >  0 && c + 1 >= matrix[0].length) {
                            continue;
                        }
                    }
//                    // checking if two places over is going to be empty or not
//                    if (r >= 0 && c >= 0 & r <= matrix.length - 1 && c <= matrix[0].length - 1) {
//                        // top left corner check
//                        if (r < row && c < col && r - 1 >= 0 && c - 1 >= 0) {
//                            if (matrix[r - 1][c - 1] == 1) {
//                                matrix[r][c] = 2;
//                            }
//                        }
//                        else {
//                            continue;
//                        }
//
//                        // above the point clicked
//                        if (r < row  && c == col) {
//                            if (matrix[r - 1][c] == 1) {
//                                matrix[r][c] = 2;
//                            }
//                            if (matrix[r][c] == 1) {
//                                matrix[r - 1][c] == 2;
//                            }
//                        }
//                        else {
//                            continue;
//                        }
//
//                        // top right corner
//
//                    }
//                    else {
//                        continue;
//                    }
                }
            }
        }
        updateBoardSize(matrix.length+1);
    }
    public boolean checkforzero(int row, int col) {
        return matrix[row][col] == 0;
    }
    public void updateBoardSize( int newWidth) {
        int[][] temp = matrix;
        matrix = new int[newWidth][newWidth];
        for (int i=0; i<(Math.max(matrix[0].length,newWidth)); i++) {
            System.arraycopy(temp[i], 0, matrix[i], 0, Math.max(matrix[0].length, newWidth));
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
/*
    //diagonal down-right
    check=(row-2,col-2)
    check=(row-1,col-1)

    //diagonal down-left
    check=(row-2,col+2)
    check=(row-1,col+1)

     //diagonal up-right
    check=(row+2,col-2)
    check=(row+1,col-1)

    //diagonal up-left
    check=(row-2,col+2)
    check=(row-1,col+1)

    //horizontal right
    check = row, col-2
    check = row, col-1

    //horizontal left
    check = row, col+2
    check = row, col+1

    //verticle down
    check = row+2, col
    check = row+1, col

    //verticle up
    check = row-2, col
    check = row-1, col

 */

