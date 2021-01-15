class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int puidx = 0;
        int poidx = 0;
        while (puidx < n || poidx < n) {
            while (puidx < n && poidx < n && pushed[puidx] != popped[poidx] ) {
                if (!stack.isEmpty() && stack.peek() == popped[poidx]) {
                    stack.pop();
                    poidx++;
                } else {
                    stack.push(pushed[puidx++]);
                }
            }
            if (puidx < n && pushed[puidx] == popped[poidx]) {
                puidx++;
                poidx++;
            } else {
                if (stack.isEmpty()) return false;
                if (stack.pop() != popped[poidx++]) return false;
            }
        }
        return true;
    }
}