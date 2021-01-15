class Solution {
    /**
     * O(n)
     * O(n)
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) return null;
        List<String> res = new ArrayList<>();
        int i = 0;
        List<String> list = new ArrayList<>();
        boolean islast = false;
        while (i < words.length) {
            list = new ArrayList<>();
            int num = 0;
            islast = false; // don't forget!!!
            while (i < words.length && num + words[i].length() <= maxWidth) {
                list.add(words[i]);
                num += words[i].length() + 1;
                i++;
            }
            if (i == words.length || list.size() == 1) {
                islast = true;
            }
            String s = helper(list, islast, maxWidth, num - 1);
            res.add(s);
        }
        return res;
    }

    public String helper(List<String> list, boolean islast, int maxWidth, int num) {
        StringBuilder sb = new StringBuilder();
        if (islast) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
                maxWidth -= (list.get(i).length() + 1);
            }
            if (maxWidth == -1) {
                return sb.toString().trim();
            }
            while (maxWidth > 0) {
                sb.append(" ");
                maxWidth--;
            }
            return sb.toString();
        }

        int interval = list.size() - 1;
        int offset = maxWidth - num;
        int sc = offset / interval + 1;
        int re = offset % interval;
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            int count = sc;
            if (re != 0) {
                count++;
                re--;
            }
            while (count > 0) {
                sb.append(" ");
                count--;
            }
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }
}