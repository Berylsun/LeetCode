class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while(i>-1||j>-1){
            int sum=carry;
            if(i>-1){sum+=a.charAt(i)-'0';i--;}   //-'0'  => change string to number
            if(j>-1){sum+=b.charAt(j)-'0';j--;}
            str.append(sum%2);
            carry=sum/2;
        }
        if (carry!=0){
            str.append(1);   //This condition is important!
        }
        return str.reverse().toString();
    }
}
