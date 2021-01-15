
public class novenary {
    public static String add (String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        String[] strs1 = num1.split("\\.");
        String[] strs2 = num2.split("\\.");
        int n = 0;
        if (strs1.length > 1) {
            n = strs1[1].length();
        }
        if (strs2.length > 1) {
            n = Math.max(n, strs2[1].length());
        }
        String min = "";
        if (n != 0) {
            if (strs1.length == 1) {
                min = strs2[1];
            } else if (strs2.length == 1){
                min = strs1[1];
            } else {
                String smin1 = strs1[1];
                String smin2 = strs2[1];
                if (strs1[1].length() < n) {
                    for (int i = 0; i < (n - strs1[1].length()); i++) {
                        smin1 += "0";
                    }
                } else {
                    for (int i = 0; i < (n - strs2[1].length()); i++) {
                        smin2 += "0";
                    }
                }
                min = helper(smin1, smin2);
            }
        }
        String num = helper(strs1[0], strs2[0]);
        if (min.length() > n) {
            num = helper(num, min.substring(0, 1));
            min = min.substring(1);
        }
        if (min == "") {
            return num;
        }
        return num + "." + min;
    }

    public static String helper(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int num1;
        int num2;
        int n = 0;
        int total;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                num1 = s1.charAt(i) - '0';
                num2 = s2.charAt(j) - '0';
                total = n + num1 + num2;
                i--;
                j--;
            } else if (i >= 0) {
                num1 = s1.charAt(i) - '0';
                total = n + num1;
                i--;

            } else {
                num2 = s2.charAt(j) - '0';
                total = n + num2;
                j--;
            }
            if (total < 9) {
                n = 0;
                res.append(total);
            } else {
                n = 1;
                res.append(total - 9);
            }
        }
        if (n != 0) {
            res.append(n);
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        String num1 = "1.28";
        String num2 = "1.71";
        String res = add(num1, num2);
        System.out.println(res);
    }
}
