//O(n)/O(1), 1
class Solution {
    String[] less20={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] ten = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int i = 0;
        
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + thousands[i] + " " + res;
            }
            num /= 1000;
            i++;
        }
        
        return res.trim();
    }
    
    public String helper(int num) {
        String res = "";
        if (num == 0) return "";
        if (num > 99) {
            res = less20[num / 100] + " Hundred " + helper(num % 100);
        }else if (num > 19) {
            res = ten[num / 10] + " " + helper(num % 10);
        }else {
            res = less20[num] + " ";
        }
        return res;
    }
}
