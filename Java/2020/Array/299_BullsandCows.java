//O(n), O(1)
class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int A = 0;
        int B = 0;
        for (int i = 0; i < secret.length(); i++) {
            int idx = secret.charAt(i) - '0';
            if (guess.charAt(i) == secret.charAt(i)) {
                A++;
            }
            count[idx]++;
        }

        for (int i = 0; i < guess.length(); i++) {
            int idx = guess.charAt(i) - '0';
            if (count[idx] > 0) {
                B++;
                count[idx]--;
            }
        }

        String res = A + "A" + (B - A) + "B";
        return res;
    }
}

// improve -> if there is order, make notes of both
class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] count = new int[10];
        int n = secret.length();

        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                int sidx = secret.charAt(i) - '0';
                int gidx = guess.charAt(i) - '0';
                if (count[sidx] < 0) {
                    B++;
                }
                if (count[gidx] > 0) {
                    B++;
                }
                count[sidx]++;
                count[gidx]--;
            }
        }

        return A + "A" + B + "B";
    }
}