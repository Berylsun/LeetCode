class solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long alower = (long) lower,aupper = (long) upper;
        for (int num : nums) {
            if (alower == num) {
                alower++;
            }else {
                if (alower + 1 == num) {
                    res.add(String.valueOf(alower));
                }else {
                    res.add(alower + "->" + (num - 1));
                }
                alower = (long)num + 1;
            }
        }
        if (alower == aupper) {
            res.add(String.valeOf(alower));
        }else if (alower < aupper) {
            res.add(alower + "->" + aupper);
        }
        return res;
    }
}
