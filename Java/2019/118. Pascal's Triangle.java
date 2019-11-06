class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        while(res.size()<numRows){
            num.add(0,1);    
            for (int i =1;i<num.size()-1;i++){
                num.set(i,num.get(i)+num.get(i+1));
            }
            res.add(new ArrayList<>(num));
        }
        return res;
    }
}
