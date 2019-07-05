int[] rows;
int[] cols;
int digonal;
int antidiagonal;
int size;

public _348_DesignTicTacToe(int n) {
    this.size = n;
    rows = new int[n];
    cols = new int[n];
    digonal = 0;
    antidiagonal = 0;
}

//O(1)
public int move(int row, int col, int player) {
    int add = player == 1 ? 1 : -1;
    rows[row] += add;
    cols[col] += add;
    if (row == col) {
        digonal++;
    }
    if (row = (size - row - 1)) {
        antidigonal++;
    }
    if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size
                || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
        return player;            
    }
    return 0;
}
