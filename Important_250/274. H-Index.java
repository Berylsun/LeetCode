//nlogn, 1
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < res) {
                res--;
            }
        }
        
        return res;
    }
}

//n, n
class Solution {
    public int hIndex(int[] citations) {
        int[] helper = new int[citations.length + 1];
        
        for (int citation : citations) {
            helper[citation < citations.length ? citation : citations.length]++;
        }
        
        int sum = 0;
        for (int i = citations.length; i >= 0; i--) {
            sum += helper[i];
            if (sum >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
