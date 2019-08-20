//nlogk, k
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.poll();
    }
}

//n, 1
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (true) {
            int pos = partition(left, right, nums);
            if (pos + 1 == k) {
                return nums[pos];
            }
            if (pos + 1 > k) {
                right = pos - 1;
            }else {
                left = pos + 1;
            }
        }
    }
    
    public int partition (int left, int right, int[] nums) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        
        while (l <= r) {
            if (nums[l] < pivot && pivot < nums[r]) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) {
                l++;
            }
            if (nums[r] <= pivot) {
                r--;
            }
        }
        
        swap(nums, left, r);
        return r;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
