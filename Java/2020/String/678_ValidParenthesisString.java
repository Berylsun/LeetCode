/**
 * O(n)
 * O(n)
 */
class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> sstack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                lstack.push(i);
            } else if (c == '*') {
                sstack.push(i);
            } else {
                if (lstack.size() == 0 && sstack.size() == 0) {
                    return false;
                }
                if (lstack.size() == 0 ) {
                    sstack.pop();
                } else {
                    lstack.pop();
                }
            }
        }
        if (lstack.size() > sstack.size()) return false;
        while (!lstack.isEmpty()) {
            if (sstack.isEmpty()) {
                return false;
            }
            if (sstack.pop() < lstack.pop()) {
                return false;
            }
        }
        return true;
    }
}

/**
 * O(n)
 * O(1)
 */
class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
}