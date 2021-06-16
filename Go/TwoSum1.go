package Go
//O(n) O(n)
func twoSum(nums []int, target int) []int {
	hmap := map[int]int{}
	res := make([]int, 0, 2)
	for i := 0; i < len(nums); i++ {
		if j, ok := hmap[target - nums[i]] ; ok {
			res = append(res, j)
			res = append(res, i)
			break
		}
		hmap[nums[i]] = i
	}
	return res
}
