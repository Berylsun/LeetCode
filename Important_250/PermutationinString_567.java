class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] cnt = new int[26];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < s2.length(); i++) {
            int x = s2.charAt(i) - 'a';
            int y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[y] == 0) {
                diff++;
            }
            cnt[y]++;
            if (cnt[y] == 0) {
                diff--;
            }
            if (cnt[x] == 0) {
                diff++;
            }
            cnt[x]--;
            if (cnt[x] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }


    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] cnt = new int[26];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']--;
        }

        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            int x = s2.charAt(i) - 'a';
            cnt[x]++;
            while (cnt[x] > 0) {
                cnt[s2.charAt(left) - 'a']--;
                left++;
            }
            if (i - left + 1 == n) {
                return true;
            }
        }

        return false;
    }
}