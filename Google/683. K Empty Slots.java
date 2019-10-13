//n, n

/*
  record the day when the bulbs turns on 
  find postion left -> right(k + 1 + left) 
  where pos[i] > pos[left] && pos[i] > pos[right] 
  means the day the bulbs turns on is later than left -> right
*/
class Solution {
    public int kEmptySlots(int[] bulbs, int K) {
        int[] pos = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++) {
            pos[bulbs[i] - 1] = i + 1;
        }
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = K + 1;
        for (int i = 0; right < bulbs.length; i++) {
            if (pos[i] < pos[left] || pos[i] <= pos[right]) {
                //success
                if (i == right) {
                    res = Math.min(res, Math.max(pos[left], pos[right]));
                }
                
                left = i;
                right = i + K + 1;
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
