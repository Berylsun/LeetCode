//less than m*n
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null ||sentence.length == 0) return 0;
        
        //format
        String s = String.join(" ", sentence) + " ";
        
        //filling the grid
        int start = 0; //index of s(circle); 
        int len = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            }else {
                // not ' ' but is the last letter in a word 
                // which can also move to next rows
                
                //move to next row but we need to know the start word 
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        
        return start / len;
    }
}
