package Go

func searchInsert(nums []int, target int) int {
	l := 0
	r := len(nums) - 1
	for l <= r {
		mid := (r - l) / 2 + l
		if nums[mid] == target {
			return mid
		}
		if nums[mid] < target {
			l++
		} else {
			r--
		}
	}
	return l
}