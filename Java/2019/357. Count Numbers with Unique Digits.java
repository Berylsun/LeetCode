//O(1), O(1)
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //10; 9*9; 9*9*8; 9*9*8*7……
        if (n == 0) {return 1;}
        int endavailable = 9;
        int unique = 9;
        int res = 10;
        while (endavailable >= 0 && --n > 0) { 
            //每次while循环：n都先减1，然后再和0比较
            unique *= endavailable;
            endavailable--;
            res += unique;
        }
        return res;
    }
}
