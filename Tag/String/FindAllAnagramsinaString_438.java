import java.util.*;

public class FindAllAnagramsinaString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (n > m) return res;
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        for (int i = 0; i < n; i++) {
            cntP[p.charAt(i) - 'a']++;
            cntS[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cntP, cntS)) {
            res.add(0);
        }
        for(int i = n; i < m; i++) {
            cntS[s.charAt(i) - 'a']++;
            cntS[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(cntP, cntS)) {
                res.add(i - n + 1);
            }
        }
        return res;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (n > m) return res;
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        for (int i = 0; i < n; i++) {
            cntP[p.charAt(i) - 'a']++;
        }

        int l = 0;
        for (int r = 0; r < m; r++) {
            cntS[s.charAt(r) - 'a']++;
            while (cntS[s.charAt(r) - 'a'] > cntP[s.charAt(r) - 'a']) {
                cntS[s.charAt(l) - 'a']--;
                l++;
            }
            if (r - l + 1 == n) {
                res.add(l);
            }
        }

        return res;
    }
    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (n > m) return res;

        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;
        while (r < m) {
            if (cnt[s.charAt(r) - 'a'] > 0) {
                cnt[s.charAt(r) - 'a']--;
                r++;
                if (r - l == n) {
                    res.add(l);
                }
            } else {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
        }
        return res;
    }
}
