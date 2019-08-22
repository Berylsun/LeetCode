//logn, 1
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        int j = num;
        
        while (i <= j) {
            long mid = (j - i) / 2 + i; //mid * mid > Integer.MAX_VALUE
            if (mid * mid == num) {
                return true;
            }else if (mid * mid < num) {
                i = (int)mid + 1;
            }else {
                j = (int)mid - 1;
            }
        }
        
        return false;
    }
}

//sqrt(n), 1
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 1) return true;
        for (long i = 1; i * i <= num; i++) { //i * i > Integer.MAX_VALUE
            if (i * i == num) return true;
        }
        return false;
    }
}
