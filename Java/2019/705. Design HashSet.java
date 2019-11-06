class MyHashSet {    
    private boolean[] res;
        
    /** Initialize your data structure here. */
    public MyHashSet() { //https://yangmingjiayou.iteye.com/blog/151865
        res=new boolean[1000000];
    }
    
    public void add(int key) {
        if (res[key]!=true){
            res[key]=true;
        }
    }
    
    public void remove(int key) {
        if (res[key]==true){
            res[key]=false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return res[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
