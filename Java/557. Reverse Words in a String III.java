class Solution {
    public String reverseWords(String s) {
        String[] res=s.split(" ");
        StringBuilder ans=new StringBuilder();
        
        for (int i=0;i<res.length;i++){
            StringBuilder temp=new StringBuilder(res[i]); //convert string to StringBuilder
            temp.reverse();
            ans.append(temp);
            ans.append(" ");
        }
        if(ans.length()>=1){ans.deleteCharAt(ans.length()-1);}
        return ans.toString();
    }
}
