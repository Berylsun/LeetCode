public class Codec {
    /**
     * O(n)
     * O(n)
     * @param strs
     * @return
     */

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length()).append("/").append(strs.get(i));
        }
        String s = sb.toString();
        return s;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = s.length();
        int num = 0;
        while (i < n) {
            while (s.charAt(i) != '/') {
                num = 10 * num + (s.charAt(i++) - '0');
            }
            res.add(s.substring(i + 1, i + 1 + num));
            i = i + num + 1;
            num = 0;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));