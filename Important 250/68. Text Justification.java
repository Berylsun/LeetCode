//n, n
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int index = 0;
        
        while (index < words.length) {
            StringBuilder sb = new StringBuilder();
            int count = words[index].length();
            int last = index;
            index++;
            while (index < words.length && words[index].length() + count + 1<= maxWidth) {         
                count += words[index].length() + 1;
                index++;
            }
            int diff = index - last - 1;
            sb.append(words[last]);
            if (diff == 0 || index == words.length) {
                for (int i = last + 1; i < index; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            }else {
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = last + 1; i < index; i++) {
                    for (int k = 0; k <= spaces; k++) {
                        sb.append(" ");
                    }
                    if (r > 0) {
                        sb.append(" ");
                        r--;
                    }
                    sb.append(words[i]);
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
