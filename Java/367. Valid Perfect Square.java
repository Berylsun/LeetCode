class Solution {
    public boolean isPerfectSquare(int num) {
        long res = num;
        while (res * res > num) {
            res = (res + num / res) / 2;
        }
        if (res * res == num) return true;
        return false;        
    }
}

//Newton Method
class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == num) {
                return true;
            }else if (mid * mid > num) {
                high = (int)mid - 1;
            }else {
                low = (int)mid + 1;
            }
        } 
        return false;
    }
}


class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}


class Solution {
    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num / i; i++) {
            if (num == i*i) {
                return true;
            }
        }
        return false;
    }
}
