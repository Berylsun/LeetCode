class Solution {
    /**
     * O(max(m, n))
     * O(m)
     * m = klen
     * n = Alen
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        String k = Integer.toString(K);
        int m = 0;
        int a = A.length - 1;
        int kidx = k.length() - 1;
        List<Integer> list = new ArrayList<>();
        while (a >= 0 || kidx >= 0) {
            int sum = m;
            if (a >= 0) {
                sum += A[a];
                a--;
            }
            if (kidx >= 0) {
                sum += k.charAt(kidx) - '0';
                kidx--;
            }
            list.add(sum % 10);
            m = sum / 10;
        }
        if (m != 0)  {
            list.add(m);
        }
        Collections.reverse(list);   // !!!
        return list;
    }
}