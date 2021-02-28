class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int max = Math.max(nums1.length, nums2.length);
        int min = Math.min(nums1.length, nums2.length);
        if (max > (min * 6)) {
            return -1;
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 > sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        // should be abs, sum1 may not be the total of origin nums1 after convert
        int cut = Math.abs(sum1 - sum2);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // length should be reasigned after convert arr
        int m = nums1.length;
        int n = nums2.length;
        int start1 = 0;
        int start2 = n - 1;
        int count = 0;
        while (start1 < m || start2 >= 0) {
            count++;
            if (start1 >= m) {
                cut -= (nums2[start2] - 1);
                nums2[start2] = 1;
                start2--;
                if (cut <= 0) {
                    return count;
                }
                continue;
            }
            if (start2 < 0) {
                cut -= (6 - nums1[start1]);
                nums1[start1] = 6;
                start1++;
                if (cut <= 0) {
                    return count;
                }
                continue;
            }

            //比较
            int sub1 = 6 - nums1[start1];
            int sub2 = nums2[start2] - 1;
            if (sub1 >= sub2) {
                cut -= (6 - nums1[start1]);
                nums1[start1] = 6;
                start1++;
                if (cut <= 0) {
                    return count;
                }
            } else {
                cut -= (nums2[start2] - 1);
                nums2[start2] = 1;
                start2--;
                if (cut <= 0) {
                    return count;
                }
            }
        }
        return -1;
    }
}