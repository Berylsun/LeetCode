//     time : O(n) / O(1)
//     space : O(1)
class Solution {
    String[] less20={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens={"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands={"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int count = 0;
        
        while (num > 0) {
            //1000 000 -> one million, but not one million thousands
            if (num % 1000 != 0) {
                res = helper(num % 1000) + " " + thousands[count] + " " + res;
            }
            
            count++;
            num /= 1000;
        }
        
        return res.trim();
    }
    
    public String helper(int num) {
        String res = "";
        if (num / 100 > 0) {
            res = less20[num / 100] + " Hundred " + helper(num % 100);
        }else if (num >= 20) {
            res = tens[num / 10] + " " + helper(num % 10);
        }else {
            res = less20[num % 20];
        }
        
        return res.trim();
    }
}
