
    HashMap<Integer, Integer> map;
    public _170_TwoSumIII_Datastructuredesign() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
        }else {
            map.put(number, map.get(number) + 1);
        }
    }
    
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map) {
            int i = entry.getKey();
            int j = value - i;
            if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) return true;
        }
        return false;
    }
    
    //--------------------------------------------------------------------
    
    //构造函数，leetcode中是TwoSum, map 在上一个解法中有

    private List<Integer> list;

    public void TwoSum() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void add2(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
            list.add(number);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    // time : O(n)
    public boolean find2(int value) {
        for (Integer num1 : list) {
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
