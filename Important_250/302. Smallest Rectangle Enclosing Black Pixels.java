//O(m log n + n log m), 1
/*
  For example, given the following image:
     [
     "0010",
     "0110",
     "0100"
     ]

     011
     011
     011

     and x = 0, y = 2,
     Return 6.
*/

public int minArea(char[][] image, int x, int y) {
    if (image == null || image.length == 0 || image[0].length == 0) return 0;
    
    int m = image.length;
    int n = image[0].length;
    
    int left = findLeft(image, 0, y, true);
    int right = findRight(image, y, n - 1, true);
    int top = findLeft(image, 0, x, false);
    int bottom = findRight(image, x, m - 1, false);
    
    return (right - left + 1) * (bottom - top + 1);
}

public int findLeft(char[][]image, int i, int j, boolean isHor) {
    while (i + 1 < j) {
        int mid = (j - i) / 2 + i;
        if (hasBlack(mid, image, isHor)) {
            j = mid;
        }else {
            i = mid;
        }
    }
    if (hasBlack(i, image, isHor)) {
        return i;
    }
    return j;
}

public int findRight(char[][]image, int i, int j, boolean isHor) {
    while (i + 1 < j) {
        int mid = (j - i) / 2 + i;
        if (hasBlack(mid, image, isHor)) {
            i = mid;
        }else {
            j = mid;
        }
    }
    if (hasBlack(j, image, isHor)) {
        return j;
    }
    return i;
}

public boolean hasBlack(int num, char[][] image, boolean isHor) {
    if (isHor) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][num] == '1') return true;
        }
    }else {
        for (int i = 0; i < image[0].length; i++) {
            if (image[num][i] == '1') return true;
        }    
    }
    
    return false;
}
