class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> res1 = new HashSet<>();
        for(int i:nums1){
            res1.add(i);
        }
        Set<Integer> res2 = new HashSet<>();
        for(int i:nums2){
            res2.add(i);
        }
        for(int i:res1){
            if (res2.contains(i)){
                res.add(i);
            }
        }
        int[]ans=new int[res.size()];
        int a=0;
        for (int i:res){
            ans[a]=i;
            a++;
        }
        return ans;
    }
}
