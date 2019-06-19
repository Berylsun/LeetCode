//n, 1
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null || s.length() == 0) return 0;
    int res = 0;
    int num = 0;
    int j = 0;
    int[] count = new int[256];
 
    for (int i = 0; i < s.length(); i++) {
        if (count[s.charAt(i)]++ == 0) {
            num++;
        }
        if (num > k) {
            while (--count[s.charAt(j++)] > 0);
            num--;
        }
        res = Math.max(res, i - j + 1);
    }
    return res;
}
