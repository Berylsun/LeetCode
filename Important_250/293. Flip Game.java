//n^2, n

public List<String> generatePossibleNextMoves(String s) {
    List<String> res = new ArrayList<>();
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
            res.add(s.substring(0, i) + '--' + s.substring(i + 1));
        }
    }
    
    return res;
}
