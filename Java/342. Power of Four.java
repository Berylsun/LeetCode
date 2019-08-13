class Solution {
    public boolean isPowerOfFour(int num) {
        if (num > 0) {
            while (num % 4 == 0) {
                num /= 4;
            }
            if (num == 1) {
                return true;
            }
        }
        
        return false;
    }
}


class Solution {
    public boolean isPowerOfFour(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
}
