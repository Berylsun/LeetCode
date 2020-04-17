/**
 * O(max(m,n));
 * O(1);
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        if (v1.length > v2.length) {
            int num = compareVersion(version2, version1);
            if (num == 1) {
                return -1;
            }
            if (num == 0) {
                return 0;
            }
            return 1;
        }
        for (int i = 0; i < v1.length; i++) {
            String s1 = v1[i];
            String s2 = v2[i];
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
        }


        for (int i = v1.length; i < v2.length; i++) {
            int num = Integer.parseInt(v2[i]);
            if (num != 0) {
                return -1;
            }

        }
        return 0;
    }
}