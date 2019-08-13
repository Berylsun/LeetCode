class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        while(res.size()< rowIndex+1){
            res.add(0,1);
            for(int i=1;i<res.size()-1;i++){    //res.size()-1 because the last one should always be 1
                res.set(i,res.get(i)+res.get(i+1));  //choose i,i+1 instead of i,i-1,because the val before i has been changed!!! 
            }
        }
        return res;
    }
}

1. //res.size()-1 because the last one should always be 1.
2. //choose i,i+1 instead of i,i-1,because the val before i has been changed!!! 
