class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0||nums==null){return 0;}
        int sum=0;
        for(int i =0;i<nums.length;i=i+2){
            sum+=nums[i];
        }
        return sum;
    }
}


class Solution {
    public int arrayPairSum(int[] nums) {
        int[] exist = new int[20001];
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i] + 10000]++;
		}
		int sum = 0;
		boolean odd = true;
		for (int i = 0; i < exist.length; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
    }
}
