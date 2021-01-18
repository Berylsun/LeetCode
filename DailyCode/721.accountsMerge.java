class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                List<Integer> list = new ArrayList<>();
                if (map.containsKey(accounts.get(i).get(j))) {
                    list = map.get(accounts.get(i).get(j));
                }
                list.add(i);
                map.put(accounts.get(i).get(j), list);
            }
        }
        int[] nums = new int[accounts.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        int emailnums = map.size();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int x = findParent(nums, list.get(0));
            for (int i = 1; i < list.size(); i++) {
                int y = findParent(nums, list.get(i));
                nums[y] = x;
            }
        }
        HashMap<Integer, List<Integer>> remap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int root = findParent(nums, i);
            if (remap.containsKey(root)) {
                list = remap.get(root);
            }
            list.add(i);
            remap.put(root, list);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : remap.entrySet()) {
            List<String> list = new ArrayList<>();
            int key = entry.getKey();
            list.add(accounts.get(key).get(0));
            HashSet<String> set = new HashSet<>();
            for (int index : entry.getValue()) {
                for (int i = 1; i < accounts.get(index).size(); i++) {
                    set.add(accounts.get(index).get(i));
                }
            }
            List<String> emailList = new ArrayList<>(set);
            Collections.sort(emailList);
            list.addAll(emailList);
            res.add(list);
        }
        return res;
    }

    public int findParent(int[] nums, int i) {
        if (nums[i] != i) {
            nums[i] = findParent(nums, nums[i]);
        }
        return nums[i];
    }
}