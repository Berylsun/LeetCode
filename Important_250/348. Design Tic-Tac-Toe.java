int[] rows;
int[] cols;
int diagonal;
int antiDiagonal;
int size;

public _348_DesignTicTacToe(int n) {
    size = n;
    rows = new int[n];
    cols = new int[n];
    diagonal = 0;
    antiDiagonal = 0;
}

//O(1)
public int move(int row, int col, int player) {
    int add = player == 1 ? 1 : -1;
    
    rows[row] += add;
    cols[col] += add;
    if (row = col) {
        diagonal += add;
    }
    if (row = -col) {
        antiDiagonal += add;
    }
    
    if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
        return player;
    }
    
    return 0;
}
