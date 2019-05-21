class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        int[] digit = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int val = product + digit[i + j + 1];
                digit[i + j] += val / 10;
                digit[i + j + 1] = val % 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int num : digit) {
            if (!(num == 0 && res.length() == 0)) {
                res.append(num);
            }
        }
        return res.length() == 0 ? "0": res.toString();
    }
}
