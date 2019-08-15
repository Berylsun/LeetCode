//n, 1
public int findCelebrity(int n) {
    if (n < 2) return -1;
    int res = 0;
    for (int i = 1; i < n; i++) {
        if (knows(res, i)) {
            res = i;
        }
    }
    
    for (int i = 0; i < n; i++) {
        if (i != res && (!knows(i, res) || knows(res, i))) {
            return -1;
        }
    }
    
    return res;
}

public boolean knows(int a, int b) {
    return true;
}
