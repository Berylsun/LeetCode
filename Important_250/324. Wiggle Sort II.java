//nlogn, n
public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = (n - 1) / 2;
        int index = 0;
        int[] temp = new int[n];
        for (int i = 0; i <= mid; i++) {
            temp[index] = nums[mid - i];
            if (index + 1 < n) {
                temp[index + 1] = nums[n - 1 - i];
            }
            index += 2;
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }

//n, 1
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null ||  nums.length == 0) return;
        int n = nums.length;
        int mid = findKthLargest(nums, (n + 1) / 2);  //(n + 1)
        int left = 0;
        int right = n - 1;
        int index = 0;
        while (index <= right) {
            if (nums[newIndex(index, n)] > mid) {
                swap(nums, newIndex(index++, n), newIndex(left++, n));
            }else if (nums[newIndex(index, n)] < mid) {
                swap(nums, newIndex(index, n), newIndex(right--, n));
            }else {
                index++;
            }
        }
        
    }
    
    public int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }
    
    //215
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
