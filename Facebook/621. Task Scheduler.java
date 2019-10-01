//n, 1
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] letters = new int[26];
        int max = 0;
        int maxType = 0;
        for (int i = 0; i < tasks.length; i++) {
            int index = tasks[i] - 'A';
            letters[index]++;
            if (max == letters[index]) {
                maxType++;
            }else if (max < letters[index]) {
                maxType = 1;
                max = letters[index];
            }
        }
        
        int times = max - 1;
        int idle = n - (maxType - 1);
        int idleAll = times * idle;
        int others = tasks.length - max * maxType;
        int idles = Math.max(0, idleAll - others);
        
        return tasks.length + idles;
    }
}
