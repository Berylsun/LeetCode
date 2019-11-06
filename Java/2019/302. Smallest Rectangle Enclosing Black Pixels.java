   // time : O(m log n + n log m)
   // space : O(1)
    
    public int minArea(char[][] image, int x, int y) {
        int row = image.length;
        int col = image[0].length;
        int left = findLeft(image, 0, y, true);
        int right = findRight(image, y, col - 1,true);
        int top = findLeft(image, 0, x, false);
        int bottom = findRight(image, x, row - 1, false);
        return (right - left + 1) * (bottom - top + 1);
    }
    
    public int findLeft(int[][]image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                right = mid;
            }else {
                left = mid;
            }
        }
        if (hasBlack(image, left, isHor)) return left;
        return right;       
    }
    
     public int findRight(int[][]image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if (hasBlack(image, right, isHor)) return right;
        return left;       
    }
    
    public boolean hasBlack(int[][]image, int x, boolean isHor) {
        if (isHor) {
            for (int i = 0; i < image.length; i++) {
                if(image[i][x] == '1') return true;            
            }
        }else {
            for (int i = 0; i < image[0].length; i++) {
                if(image[x][i] == '1') return true;            
            }
        }
        return false;
    }
