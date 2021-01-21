class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeronums = 0;
        int count = 0;
        for (int i = 4; i >= 0; i--) {
            if (nums[i] == 0) {
                zeronums = i + 1;
                break;
            }
            if (i != 4) {
                if (nums[i + 1] == nums[i]) return false;
                count += nums[i + 1] - nums[i] - 1;
            }
        }
        return count <= zeronums;
    }

    /**
     * O(nlogn)
     * O(1)
     * @param nums
     * @return
     */
    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int zeronums = 0;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                zeronums++;
            } else if (i < 4 && nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[zeronums] < 5;
    }

    /**
     * O(n)
     * O(n)
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}