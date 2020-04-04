/**
 * unknown
 * O(n)
 */
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int num = 0;
            while (n > 0) {
                num += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = num;
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}