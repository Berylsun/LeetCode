/**
 * O(1)
 */
class RandomizedSet {

    HashMap<Integer, Integer> map;
    Random rmd;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rmd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        if (!res) {
            map.put(val, list.size());
            list.add(val);
        }
        return !res;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        map.remove(val);
        int lastval = list.remove(list.size() - 1);
        if (index != list.size()) {
            map.put(lastval, index);
            list.set(index, lastval);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
