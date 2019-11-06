//n, 1
class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            }else {
                if (count[secret.charAt(i) - '0']++ < 0) B++;
                if (count[guess.charAt(i) - '0']-- > 0) B++;
            }            
        }
        return A + "A" + B + "B";
    }
}
