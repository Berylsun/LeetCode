//n, n
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.remove(num);
                }else {
                    map.put(num, map.get(num) - 1);
                }
                res.add(num);
            }            
        }
        
        int[] re = new int[res.size()];
        
        for (int i = 0; i < re.length; i++) {
            re[i] = res.get(i);
        }
        
        return re;
    }
}


//nlogn, n
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        
        List<Integer> res = new ArrayList<>();
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }else if (nums1[i] > nums2[j]) {
                j++;
            }else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] re = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            re[k] = res.get(k);
        }
        
        return re;
    }
}
