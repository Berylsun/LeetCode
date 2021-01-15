package bilibili;
//leetcode 1004

public class P1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int n = 2;
        P1 p = new P1();
        int res = p.GetMaxConsecutiveOnes(nums, n);
        System.out.println(res);
    }

    public int GetMaxConsecutiveOnes(int[] A, int K) {
        int res = 0;
        if (A == null || A.length == 0) {
            return res;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < A.length) {
            if (A[right++] == 0) {
                count++;
            }
            if (count > K) {
                while (left < A.length && A[left] == 1) {
                    left++;
                }
                left++;
                count--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
