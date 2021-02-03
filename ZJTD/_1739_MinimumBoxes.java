class Solution {
    /**
     * O(n^(1/2))
     * O(1)
     * @param n
     * @return
     */
    public int minimumBoxes(int n) {
        int level = 0;
        int cell = 0;
        while (cell + (1 + level) * level / 2 <= n) {
            cell += (1 + level) * level / 2;
            level++;
        }
        level--;
        int area = (1 + level) * level / 2;
        int now = 0;

        while (cell < n) {
            area++;
            cell += now + 1;
            now++;
        }

        return area;
    }

    /**
     * O(logn)
     * O(1)
     * @param n
     * @return
     */
    public int minimumBoxes(int n) {
        long l = 0;
        long r = 2000;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long area = mid * (mid + 1) * (mid + 2) / 6;
            if (area >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        long d = l - 1;
        long darea = (1 + d) * d / 2;
        long cell = d * (d + 1) * (d + 2) / 6;

        long target = n - cell;
        l = 0;
        r = target;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long area = mid * (mid + 1) / 2;
            if (area >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return (int) (l + darea);
    }
}