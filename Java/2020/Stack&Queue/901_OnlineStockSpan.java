class StockSpanner {
    ArrayList<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }

    /**
     * O(n)
     * O(1)
     * @param price
     * @return
     */
    public int next(int price) {
        int res = 0;
        list.add(price);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) <= price) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }


    Stack<int[]> stack;
    public StockSpanner2() {
        stack = new Stack<>();
    }

    /**
     * O(1)
     * O(n)
     * @param price
     * @return
     */
    public int next2(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            res += stack.pop()[1];
        }
        stack.push(new int[]{price, res});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */