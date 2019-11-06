//n, n
public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[26];
        int[] valid = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int nextLetter = findNext(count, valid, i);
            if (nextLetter = -1) return "";
            res.append((char)(nextLetter + 'a'));
            count[nextLetter]--;
            valid[nextLetter] = i + k;
        }
        return res.toString;
    }
    
    public int findNext(int[] count, int[] valid, int index) {
        int max = 0;
        int res = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && valid[i] <= index) {
                res = i;
                max = count[i];
            }
        }
        return res;
    }

    
