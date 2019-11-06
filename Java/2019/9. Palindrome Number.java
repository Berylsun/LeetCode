class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        int cur = 0;
        while (x > 0) {
            cur = x %10;
            nums.add(cur);
            x /= 10;
        }
        int low = 0;
        int high = nums.size() - 1;
        while (low < high) {
            if(nums.get(low) != nums.get(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    
    
    
    public boolean isPalindrome2(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false;
        int palind = x;
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return palind == rev;
    }
}


