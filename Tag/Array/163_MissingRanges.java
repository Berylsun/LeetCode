/**
 * O(n)
 * O(n)
 */
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long alower = (long) lower;
        for (int num : nums) {
            if (num == alower) {
                alower++;
            } else {
                if (num > alower) {
                    if (num - 1 == alower) {
                        res.add(Long.toString(alower));
                    } else {
                        res.add(alower + "->" + (num - 1));
                    }
                    alower = (long)num + 1;
                }
            }
        }
        if (alower == upper) {
            res.add(Integer.toString(upper));
        } else if (alower < upper) {
            res.add(alower + "->" + upper);
        }
        return res;
    }
}