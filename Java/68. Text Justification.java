//n, n
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int index = 0;
        while(index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (count + 1 + words[last].length() > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1;
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            }else {
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k > 0; k--) {
                        builder.append(" ");
                    }
                    builder.append(" ");
                    if (r > 0) {
                        builder.append(" ");
                        r--;
                    }
                    builder.append(words[i]);
                }
            }
            res.add(builder.toString());
            index = last;
        }
        return res;
    }
}
