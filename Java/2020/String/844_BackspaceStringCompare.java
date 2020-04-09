/**
 * O(n)
 * O(n)
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }

    public String helper(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }

            }
            i++;
        }
        return sb.toString();
    }
}

/**
 * O(n)
 * O(1)
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return S == T;
        int i = S.length() - 1;
        int j = T.length() - 1;
        int cns = 0;
        int cnt = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (cns > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') {
                    cns++;
                } else {
                    cns--;
                }
                i--;
            }
            while (j >= 0 && (cnt > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') {
                    cnt++;
                } else {
                    cnt--;
                }
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
        return true;
    }
}