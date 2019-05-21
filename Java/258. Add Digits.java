class Solution {
    public int addDigits(int num) {
        return(1+(num-1)%9);
    }
}



class Solution {
    public int addDigits(int num) {
        return addDigits1(num);
    }
    public static int addDigits1(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum >= 10) {
            return addDigits1(sum);
        } else {
            return sum;
        }
    }
}
