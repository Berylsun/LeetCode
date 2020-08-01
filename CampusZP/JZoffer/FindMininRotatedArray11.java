class Solution {
    /**
     * O(logn)
     * O(1)
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i + 1 < j) {
            int mid = (j - i) / 2 + i;
            if (numbers[mid] < numbers[j]) {
                j = mid;
            } else if (numbers[mid]> numbers[j]) {
                i = mid + 1;
            } else {
                j--;
            }
        }
        return Math.min(numbers[i], numbers[j]);
    }
}