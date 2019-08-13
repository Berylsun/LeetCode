class Solution {
    public String reverseString(String s) {
        char[] res=s.toCharArray();
        if(s.length()==0||s==null){return s;}
        int i=0,j=s.length()-1;
        while(i<j){
            char temp=res[i];  
            res[i]= res[j];
            res[j]=temp;
            i++;
            j--;
        }
        return new String(res);    //copy
    }
}
