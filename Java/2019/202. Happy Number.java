class Solution {
    public boolean isHappy(int n) {
        Set<Integer> res = new HashSet<Integer>();
        while(res.add(n)){  //determine if it will have a circle
            int remain=0,sum=0;
            while(n>0){            
                remain=n%10;
                sum+=remain*remain;
                n=n/10; 
            }
            n=sum;
            if(sum==1){
                return true;
            }
        } 
        return false;
    }
}
